package hexlet.code;

import java.util.Random;
import java.util.Scanner;

/**
 * Class provides "Even" game logic, consisting in providing the user with
 * the opportunity to answer the question about the parity of the number
 */
public class Even {
    private String name;
    private final int MAX_RANDOM_NUM = 100;
    private final int MIN_RANDOM_NUM = 1;
    private final int MAX_SUCCES_COUNT = 3;
    private Random random;
    private Scanner scanner;

    /**
     * Parameterized class cctor
     * @param name Entered user name
     * @param scanner Standard console input object ref
     */
    public Even(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
        random = new Random();
    }

    /**
     * Method provides main game logic, consisting in asking the user questions about
     * the parity of the number until the limit of attempts is reached
     */
    public void start() {
        var succesCount = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (succesCount < MAX_SUCCES_COUNT && succesCount >= 0) {
            var currentRnd = random.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM + 1);
            System.out.println("Question: " + currentRnd);
            System.out.print("Your answer: ");
            var userSuggestion = scanner.nextLine();

            succesCount = handleSuggestion(userSuggestion, currentRnd, succesCount);
        }
        System.out.println("Congratulations, " + name + "!");
    }

    /**
     * Method that checks the entered suggestion for correctness
     * @param suggestion Entered user answer
     * @param number Question number
     * @param count Success suggestions count
     * @return Incremented @count if @suggestion is correct, -1 otherwise
     */
    private int handleSuggestion(String suggestion, int number, int count) {
        if ((suggestion.equals("yes") && number % 2 == 0)
            || (suggestion.equals("no") && number % 2 != 0)) {
                System.out.println("Correct!");
                return ++count;
        }
        var correctAnswer = suggestion.equals("yes") ? ("'no'") : ("'yes'");
        System.out.println("'" + suggestion + "' " + "is wrong answer ;(. " +
                "Correct answer was " + correctAnswer);
        System.out.println("Let's try again, " + name + "!");
        count = -1;
        return count;
    }
}
