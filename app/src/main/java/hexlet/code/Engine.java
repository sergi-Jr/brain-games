package hexlet.code;

import java.util.Random;
import java.util.Scanner;

/**
 * Utility class provides games execution.
 */
public final class Engine {
    public static final int MAX_SUCCESSES_COUNT = 3;
    private static final Random RANDOM = new Random();
    public static void execute(String rules, String[] questions, String[] answers) {
        Scanner scanner = new Scanner(System.in);
        Greeter.greet();
        String name = Greeter.getName();
        int currentSuccessesCount = 0;

        System.out.println(rules);

        for (int i = 0; i < MAX_SUCCESSES_COUNT; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            String suggestion = scanner.nextLine();

            if (suggestion.equals(answers[i])) {
                System.out.println("Correct!");
                currentSuccessesCount++;
            } else {
                if (answers[i].equals("yes") || answers[i].equals("no")) {
                    answers[i] = "'" + answers[i] + "'";
                }
                System.out.println("'" + suggestion + "'" + " is wrong answer ;(. "
                        + "Correct answer was " + answers[i]);
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
