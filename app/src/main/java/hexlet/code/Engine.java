package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 * Utility class provides games execution.
 */
public final class Engine {
    public static final int MAX_RANDOM_INT = 100;
    public static final int MIN_RANDOM_INT = 0;
    public static final int MAX_SUCCESSES_COUNT = 3;

    public static void execute(String rules, List<Map<String, String>> gameData) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        int currentSuccessesCount = 0;
        System.out.println(rules);

        for (Map<String, String> entry : gameData) {
            for (var pair : entry.entrySet()) { //many questions in round allowed
                System.out.println("Question: " + pair.getKey());
                System.out.print("Your answer: ");
                String suggestion = scanner.nextLine();

                if (suggestion.equals(pair.getValue())) {
                    System.out.println("Correct!");
                    currentSuccessesCount++;
                } else {
                    String outputAnswer = pair.getValue();
                    if (pair.getValue().equals("yes") || pair.getValue().equals("no")) {
                        outputAnswer = "'" + pair.getValue() + "'";
                    }
                    System.out.println("'" + suggestion + "'" + " is wrong answer ;(. "
                            + "Correct answer was " + outputAnswer);
                    System.out.println("Let's try again, " + name + "!");
                    scanner.close();
                    return;
                }
            }

        }
        if (currentSuccessesCount == MAX_SUCCESSES_COUNT) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
