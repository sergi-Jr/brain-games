package hexlet.code.games;

import hexlet.code.abstracts.GameBase;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Prime game class.
 */
public final class Prime extends GameBase {
    private final List<String> primes = Arrays.asList("2", "3", "5", "7", "11", "13", "17", "19",
            "23", "29", "31", "37", "41", "43", "47", "53", "59", "61", "67", "71", "73",
            "79", "83", "89", "97", "101");
    /**
     * Parameterized extended cctor.
     * @param scanner
     */
    public Prime(Scanner scanner) {
        super(scanner);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(String name) {
        setName(name);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (getSuccessCount() < getMaxSuccesses() && getSuccessCount() >= 0) {
            int currentRnd = getRandom().nextInt(getMinRandom(), getMaxRandom() + 1);

            int solution = resolveStatement(currentRnd, primes);

            System.out.println("Question: " + currentRnd);
            System.out.print("Your answer: ");
            String userSuggestion = getScanner().nextLine();

            setSuccessCount(handleSuggestion(userSuggestion, solution, getSuccessCount()));
        }
        if (getSuccessCount() == getMaxSuccesses()) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int handleSuggestion(String suggestion, int number, int count) {
        if (suggestion.equals("yes") && number == 1
            || suggestion.equals("no") && number == 0) {
            System.out.println("Correct!");
            return ++count;
        }
        var correctAnswer = suggestion.equals("yes") ? ("'no'") : ("'yes'");
        System.out.println("'" + suggestion + "' " + "is wrong answer ;(. "
                + "Correct answer was " + correctAnswer);
        System.out.println("Let's try again, " + getName() + "!");
        count = -1;
        return count;
    }

    /**
     * Method determines that number is prime.
     * @param questNum Question randomly generated number
     * @param primesList List contains prime numbers
     * @return 0 if number is not prime, 1 otherwise
     */
    private int resolveStatement(int questNum, List<String> primesList) {
        List<String> predicateSolutions = primesList.stream()
                .filter(isPrimeNumber(questNum))
                .toList();
        return predicateSolutions.isEmpty() ? 0 : 1;
    }

    /**
     * Predicate that determines whether the given number matches an element of the list.
     * @param number Number to compare
     * @return Filtered element(S)
     */
    private Predicate<String> isPrimeNumber(int number) {
        return num -> num.equals(String.valueOf(number));
    }
}
