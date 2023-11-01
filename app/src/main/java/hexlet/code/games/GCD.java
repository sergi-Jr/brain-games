package hexlet.code.games;

import hexlet.code.abstracts.GameBase;
import java.util.Scanner;

/**
 * Class provides "Greater common divisor" (GCD) game logic.
 * Consists in providing the user with the opportunity to answer the question about the finding greater common divisor
 */
public final class GCD extends GameBase {
    /**
     * Parameterized extended cctor.
     * @param scanner Standard console input object ref
     */
    public GCD(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start(String name) {
        setName(name);

        System.out.println("Find the greatest common divisor of given numbers.");

        while (getSuccessCount() < getMaxSuccesses() && getSuccessCount() >= 0) {
            int leftOperand = getRandom().nextInt(getMinRandom(), getMaxRandom() + 1);
            int rightOperand = getRandom().nextInt(getMinRandom(), getMaxRandom() + 1);
            String statement = leftOperand + " " + rightOperand;
            int solution = resolveStatement(leftOperand, rightOperand);

            System.out.println("Question: " + statement);
            System.out.print("Your answer: ");
            String userSuggestion = getScanner().nextLine();

            setSuccessCount(handleSuggestion(userSuggestion, solution, getSuccessCount()));
        }
        if (getSuccessCount() == getMaxSuccesses()) {
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
        System.out.println("Let's try again, " + getName() + "!");
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
