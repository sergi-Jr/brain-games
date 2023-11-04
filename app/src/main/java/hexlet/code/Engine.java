package hexlet.code;

import java.util.Random;
import java.util.Scanner;

/**
 * Utility class provides games execution.
 */
public final class Engine {
    private static final int MAX_RANDOM_NUM = 100;
    private static final int MIN_RANDOM_NUM = 0;
    private static final int MAX_SUCCESSES_COUNT = 3;
    private static final Random RANDOM = new Random();
    private static void showRules(String rules) {
        System.out.println(rules);
    }

    private static void showQuestion(String question) {
        System.out.println("Question: " + question);
    }
    private static boolean handleSuggestion(String userSuggestion, String answer) {
        return userSuggestion.equals(answer);
    }
    private static void showCongratulationMessage(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }
    private static void showFailureMessage(String userSuggestion, String answer, String userName) {
        if (answer.equals("yes") || answer.equals("no")) {
            answer = "'" + answer + "'";
        }
        System.out.println("'" + userSuggestion + "'" + " is wrong answer ;(. "
                + "Correct answer was " + answer);
        System.out.println("Let's try again, " + userName + "!");
    }
    public static void execute(Scanner scanner, String rules, String[] questions,
                               String[] answers) {
        Greeter.greet(scanner);
        String name = Greeter.getName();
        int currentSuccessesCount = 0;

        showRules(rules);

        for (int i = 0; i < MAX_SUCCESSES_COUNT; i++) {
            showQuestion(questions[i]);
            System.out.print("Your answer: ");
            String suggestion = scanner.nextLine();
            if (handleSuggestion(suggestion, answers[i])) {
                System.out.println("Correct!");
                currentSuccessesCount++;
            } else {
                showFailureMessage(suggestion, answers[i], name);
                break;
            }
        }
        if (currentSuccessesCount == MAX_SUCCESSES_COUNT) {
            showCongratulationMessage(name);
        }
    }
    public static int getMaxSuccessesCount() {
        return MAX_SUCCESSES_COUNT;
    }
    public static int getRandomNumber() {
        return RANDOM.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
    }
}
