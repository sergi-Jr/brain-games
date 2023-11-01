package hexlet.code.games;

import hexlet.code.abstracts.GameBase;

import java.util.Scanner;

/**
 * Class provides "Even" game logic, consisting in providing the user with
 * the opportunity to answer the question about the parity of the number.
 */
public class Even extends GameBase {
    /**
     * Parameterized extended class cctor.
     * @param scanner Standard console input object ref
     */
    public Even(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start(String name) {
        this.name = name;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        while (this.successCount < MAX_SUCCESSES && this.successCount >= 0) {
            int currentRnd = random.nextInt(MIN_RANDOM, MAX_RANDOM + 1);
            int solution = currentRnd % 2;

            System.out.println("Question: " + currentRnd);
            System.out.print("Your answer: ");
            String userSuggestion = scanner.nextLine();

            this.successCount = handleSuggestion(userSuggestion, solution, this.successCount);
        }
        if (this.successCount == MAX_SUCCESSES) {
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
        System.out.println("'" + suggestion + "' " + "is wrong answer ;(. "
                + "Correct answer was " + correctAnswer);
        System.out.println("Let's try again, " + name + "!");
        count = -1;
        return count;
    }
}
