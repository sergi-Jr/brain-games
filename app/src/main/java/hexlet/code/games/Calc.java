package hexlet.code.games;

import hexlet.code.abstracts.GameBase;
import hexlet.code.abstracts.IGame;
import java.util.Scanner;

public class Calc extends GameBase implements IGame {
    private final String[] operators = new String[] {"-", "+", "*"}; //Available math operators array

    /**
     * Parameterized extended class cctor
     * @param name Entered user name
     * @param scanner Standard console input object ref
     */
    public Calc(String name, Scanner scanner) {
        super(name, scanner);
    }
    @Override
    public void start() {
        var succesCount = 0;

        System.out.println("What is the result of the expression?");

        while (succesCount < MAX_SUCCESS_COUNT && succesCount >= 0) {
            var leftOperand = random.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM + 1);
            var rightOperand = random.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM + 1);
            var operator = getRandomOperation();
            var statement = leftOperand + " " + operator + " " + rightOperand;
            var solution = resolveStatement(leftOperand, rightOperand, operator);

            System.out.println("Question: " + statement);
            System.out.print("Your answer: ");
            var userSuggestion = scanner.nextLine();

            succesCount = handleSuggestion(userSuggestion, solution, succesCount);
        }
        if(succesCount == MAX_SUCCESS_COUNT) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    @Override
    public int handleSuggestion(String suggestion, int number, int count) {
        if (suggestion.equals(String.valueOf(number))) {
            System.out.println("Correct!");
            return ++count;
        }
        System.out.println("'" + suggestion + "' " + "is wrong answer ;(. " +
                "Correct answer was " + number);
        System.out.println("Let's try again, " + name + "!");
        count = -1;
        return count;
    }

    /**
     * Local method to get random math operator in String format
     * @return Math operator in String format
     */
    private String getRandomOperation() {
        return operators[random.nextInt(0, 3)];
    }

    /**
     * Local method to resolve math expression
     * @param leftOperand Left expression operand
     * @param rightOperand Right expression operand
     * @param operator Math operator in String format
     * @return Statement solution
     */
    private int resolveStatement(int leftOperand, int rightOperand, String operator) {
        var result = 0;
        switch (operator) {
            case ("+"):
                result = leftOperand + rightOperand;
                break;
            case ("*"):
                result = leftOperand * rightOperand;
                break;
            case ("-"):
                result = leftOperand - rightOperand;
                break;
            default:
                break;
        }
        return result;
    }
}
