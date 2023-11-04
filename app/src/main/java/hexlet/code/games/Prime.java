package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Prime game class.
 */
public final class Prime {
    private static final List<String> PRIMES = Arrays.asList("2", "3", "5", "7", "11", "13", "17", "19",
            "23", "29", "31", "37", "41", "43", "47", "53", "59", "61", "67", "71", "73",
            "79", "83", "89", "97", "101");

    public static void start(Scanner scanner) {
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[Engine.getMaxSuccessesCount()];
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            int currentRnd = Engine.getRandomNumber();
            questions[i] = String.valueOf(currentRnd);
            answers[i] = String.valueOf(resolveStatement(currentRnd));
        }
        Engine.execute(scanner, rules, questions, answers);
    }

    /**
     * Method determines that number is prime.
     * @param questNum Question randomly generated number
     * @return 0 if number is not prime, 1 otherwise
     */
    private static String resolveStatement(int questNum) {
        List<String> predicateSolutions = PRIMES.stream()
                .filter(isPrimeNumber(questNum))
                .toList();
        return predicateSolutions.isEmpty() ? "no" : "yes";
    }

    /**
     * Predicate that determines whether the given number matches an element of the list.
     * @param number Number to compare
     * @return Filtered element(S)
     */
    private static Predicate<String> isPrimeNumber(int number) {
        return num -> num.equals(String.valueOf(number));
    }
}
