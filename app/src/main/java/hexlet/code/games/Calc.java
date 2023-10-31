package hexlet.code.games;

import hexlet.code.abstracts.GameBase;

import java.util.Scanner;

public class Calc extends GameBase {
    private final String[] operators = new String[] {"-", "+", "*"}; //Available math operators array

    /**
     * Parameterized extended class cctor
     * @param scanner Standard console input object ref
     */
    public Calc(Scanner scanner) {
        super(scanner);
    }
    @Override
    public void start(String name) {
        this.name = name;

        System.out.println("What is the result of the expression?");

        while (this.successCount < MAX_SUCCESS_COUNT && this.successCount >= 0) {
            int leftOperand = random.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM + 1);
            int rightOperand = random.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM + 1);
            String operator = getRandomOperation();
            String statement = leftOperand + " " + operator + " " + rightOperand;
            int solution = resolveStatement(leftOperand, rightOperand, operator);

            System.out.println("Question: " + statement);
            System.out.print("Your answer: ");
            String userSuggestion = scanner.nextLine();

            this.successCount = handleSuggestion(userSuggestion, solution, this.successCount);
        }
        if(this.successCount == MAX_SUCCESS_COUNT) {
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
     * @param leftOperand expression Left operand
     * @param rightOperand  expression Right  operand
     * @param operator Math operator in String format
     * @return Statement solution
     */
    private int resolveStatement(int leftOperand, int rightOperand, String operator) {
        int result = 0;
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
