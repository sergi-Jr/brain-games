package hexlet.code.games;

import hexlet.code.abstracts.GameBase;

import java.util.Scanner;

public final class Calc extends GameBase {
    private final String[] operators = new String[] {"-", "+", "*"}; //Available math operators array

    /**
     * Parameterized extended class cctor.
     * @param scanner Standard console input object ref
     */
    public Calc(Scanner scanner) {
        super(scanner);
    }
    @Override
    public void start(String name) {
        setName(name);

        System.out.println("What is the result of the expression?");

        while (getSuccessCount() < getMaxSuccesses() && this.getSuccessCount() >= 0) {
            int leftOperand = getRandom().nextInt(getMinRandom(), getMaxRandom() + 1);
            int rightOperand = getRandom().nextInt(getMinRandom(), getMaxRandom() + 1);
            String operator = getRandomOperation();
            String statement = leftOperand + " " + operator + " " + rightOperand;
            int solution = resolveStatement(leftOperand, rightOperand, operator);

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
     * Local method to get random math operator in String format.
     * @return Math operator in String format
     */
    private String getRandomOperation() {
        return operators[getRandom().nextInt(0, operators.length)];
    }

    /**
     * Local method to resolve math expression.
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
