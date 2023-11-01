package hexlet.code.games;

import hexlet.code.FileParser;
import hexlet.code.abstracts.GameBase;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Prime game class.
 */
public class Prime extends GameBase {
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
        this.name = name;
        List<String> primeNumbers = null;
        try {
            primeNumbers = FileParser.getPrimeNumbers(MAX_RANDOM);
        } catch (IOException e) {
            System.out.println("Couldn't get access to the file.Check path correctness.");
            return;
        }

        System.out.println("Answer 'yes' if the number is prime, otherwise answer 'no'.");

        while (this.successCount < MAX_SUCCESSES && this.successCount >= 0) {
            int currentRnd = random.nextInt(MIN_RANDOM, MAX_RANDOM + 1);

            int solution = resolveStatement(currentRnd, primeNumbers);

            System.out.println("Question: " + currentRnd);
            System.out.print("Your answer: ");
            String userSuggestion = scanner.nextLine();

            this.successCount = handleSuggestion(userSuggestion, solution, this.successCount);
        }
        if (this.successCount == MAX_SUCCESSES) {
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
        System.out.println("Let's try again, " + name + "!");
        count = -1;
        return count;
    }

    /**
     * Method determines that number is prime.
     * @param questNum Question randomly generated number
     * @param primes List contains prime numbers
     * @return 0 if number is not prime, 1 otherwise
     */
    private int resolveStatement(int questNum, List<String> primes) {
        List<String> predicateSolutions = primes.stream()
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
