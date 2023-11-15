package hexlet.code;

import java.util.Map;
import java.util.Scanner;

/**
 * Utility class provides games execution.
 */
public final class Engine {
    public static final int MAX_RANDOM_INT = 100;
    public static final int MIN_RANDOM_INT = 0;
    public static final int MAX_SUCCESSES_COUNT = 3;
    public static String greet() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = inputScanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void execute(String rules, Map<String, String> gameData) {
        String name = greet();
        Scanner scanner = new Scanner(System.in);
        int currentSuccessesCount = 0;
        System.out.println(rules);

        for (Map.Entry<String, String> entry : gameData.entrySet()) {
            System.out.println("Question: " + entry.getKey());
            System.out.print("Your answer: ");
            String suggestion = scanner.nextLine();

            if (suggestion.equals(entry.getValue())) {
                System.out.println("Correct!");
                currentSuccessesCount++;
            } else {
                String outputAnswer = entry.getValue();
                if (entry.getValue().equals("yes") || entry.getValue().equals("no")) {
                    outputAnswer = "'" + entry.getValue() + "'";
                }
                System.out.println("'" + suggestion + "'" + " is wrong answer ;(. "
                        + "Correct answer was " + outputAnswer);
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }
        scanner.close();
        if (currentSuccessesCount == MAX_SUCCESSES_COUNT) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
