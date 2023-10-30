package hexlet.code.games;

import hexlet.code.abstracts.GameBase;
import hexlet.code.abstracts.IGame;
import java.util.Scanner;

/**
 * Class provides "Even" game logic, consisting in providing the user with
 * the opportunity to answer the question about the parity of the number
 */
public class Even extends GameBase implements IGame {
    /**
     * Parameterized extended class cctor
     * @param name Entered user name
     * @param scanner Standard console input object ref
     */
    public Even(String name, Scanner scanner) {
        super(name, scanner);
    }

    @Override
    public void start() {
        var succesCount = 0;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (succesCount < MAX_SUCCESS_COUNT && succesCount >= 0) {
            var currentRnd = random.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM + 1);
            var solution = currentRnd % 2;

            System.out.println("Question: " + currentRnd);
            System.out.print("Your answer: ");
            var userSuggestion = scanner.nextLine();

            succesCount = handleSuggestion(userSuggestion, solution, succesCount);
        }
        if(succesCount == MAX_SUCCESS_COUNT) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    public int handleSuggestion(String suggestion, int number, int count) {
        if ((suggestion.equals("yes") && number == 0)
            || (suggestion.equals("no") && number != 0)) {
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
