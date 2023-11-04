package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public final class Calc {
    private static final String[] OPERATORS = new String[] {"-", "+", "*"}; //Available math operators array
    /**
     * Local method to get random math operator in String format.
     * @return Math operator in String format
     */
    private static String getRandomOperation() {
        Random rnd = new Random();
        return OPERATORS[rnd.nextInt(0, OPERATORS.length)];
    }

    /**
     * Local method to resolve math expression.
     * @param leftOperand expression Left operand
     * @param rightOperand  expression Right  operand
     * @param operator Math operator in String format
     * @return Statement solution
     */
    private static int resolveStatement(int leftOperand, int rightOperand, String operator) {
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

    public static void start(Scanner scanner) {
        String ruleMessage = "What is the result of the expression?";
        String[] questions = new String[Engine.getMaxSuccessesCount()];
        String[] answers = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            int leftOperand = Engine.getRandomNumber();
            int rightOperand = Engine.getRandomNumber();
            String operator = getRandomOperation();
            String statement = leftOperand + " " + operator + " " + rightOperand;
            questions[i] = statement;
            answers[i] = String.valueOf(resolveStatement(leftOperand, rightOperand, operator));
        }
        Engine.execute(scanner, ruleMessage, questions, answers);
    }
}
