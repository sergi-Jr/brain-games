package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class Engine {
    public static final int MAX_RANDOM_INT = 100;
    public static final int MIN_RANDOM_INT = 0;
    public static final int MAX_SUCCESSES_COUNT = 3;

    public static void execute(String gameRule, List<Map<String, String>> gameDataCollection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");

        int currentSuccessesCount = 0;
        System.out.println(gameRule);

        for (Map<String, String> entry : gameDataCollection) {
            System.out.println("Question: " + entry.get("question"));
            System.out.print("Your answer: ");
            String suggestion = scanner.nextLine();

            if (suggestion.equals(entry.get("answer"))) {
                System.out.println("Correct!");
                currentSuccessesCount++;
            } else {
                String outputAnswer = entry.get("answer");
                if (entry.get("answer").equals("yes") || entry.get("answer").equals("no")) {
                    outputAnswer = "'" + entry.get("answer") + "'";
                }
                System.out.println("'" + suggestion + "'" + " is wrong answer ;(. "
                        + "Correct answer was " + outputAnswer);
                System.out.println("Let's try again, " + name + "!");
                scanner.close();
                return;
            }
        }
        if (currentSuccessesCount == MAX_SUCCESSES_COUNT) {
            System.out.println("Congratulations, " + name + "!");
        }
    }
}
