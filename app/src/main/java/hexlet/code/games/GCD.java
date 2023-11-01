package hexlet.code.games;

import hexlet.code.abstracts.GameBase;
import java.util.Scanner;

/**
 * Class provides "Greater common divisor" (GCD) game logic.
 * Consists in providing the user with the opportunity to answer the question about the finding greater common divisor
 */
public class GCD extends GameBase {
    /**
     * Parameterized extended cctor.
     * @param scanner Standard console input object ref
     */
    public GCD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start(String name) {
        this.name = name;

        System.out.println("Find the greatest common divisor of given numbers.");

        while (this.successCount < MAX_SUCCESSES && this.successCount >= 0) {
            var leftOperand = random.nextInt(MIN_RANDOM, MAX_RANDOM + 1);
            var rightOperand = random.nextInt(MIN_RANDOM, MAX_RANDOM + 1);
            var statement = leftOperand + " " + rightOperand;
            var solution = resolveStatement(leftOperand, rightOperand);

            System.out.println("Question: " + statement);
            System.out.print("Your answer: ");
            var userSuggestion = scanner.nextLine();

            this.successCount = handleSuggestion(userSuggestion, solution, this.successCount);
        }
        if (this.successCount == MAX_SUCCESSES) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    @Override
    public int handleSuggestion(String suggestion, int number, int count) {
        if (suggestion.equals(String.valueOf(number))) {
            System.out.println("Correct!");
            return ++count;
        }
        System.out.println("'" + suggestion + "' " + "is wrong answer ;(. "
                + "Correct answer was " + number);
        System.out.println("Let's try again, " + name + "!");
        count = -1;
        return count;
    }

    /**
     * Local method to resolve math expression.
     * @param leftOperand expression Left operand
     * @param rightOperand  expression Right  operand
     * @return Statement solution
     */
    private int resolveStatement(int leftOperand, int rightOperand) {
        int greaterOperand = Math.max(leftOperand, rightOperand);
        int lessOperand = Math.min(leftOperand, rightOperand);

        while (lessOperand != 0) {
            int temp = greaterOperand % lessOperand;
            greaterOperand = lessOperand;
            lessOperand = temp;
        }
        return greaterOperand;
    }
}
