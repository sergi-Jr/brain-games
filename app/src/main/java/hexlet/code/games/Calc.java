package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.Random;

public final class Calc {
    private static final String[] OPERATORS = new String[] {"-", "+", "*"}; //Available math operators array


    /**
     * Local method to resolve math expression.
     * @param leftOperand expression Left operand
     * @param rightOperand  expression Right  operand
     * @param operator Math operator in String format
     * @return Statement solution
     */
    private static int resolveStatement(int leftOperand, int rightOperand, String operator) {
        return switch (operator) {
            case ("+") -> leftOperand + rightOperand;
            case ("*") -> leftOperand * rightOperand;
            case ("-") -> leftOperand - rightOperand;
            default -> throw new Error("Error occurs in Calc.resolveStatement(int, int, String) method."
                    + " @param int leftOperand = " + leftOperand
                    + " @param int rightOperand = " + rightOperand
                    + " @param String operator = " + operator
                    + " Unknown to resolve operator " + operator);
        };
    }

    public static void start() {
        String ruleMessage = "What is the result of the expression?";
        String[] questions = new String[Engine.MAX_SUCCESSES_COUNT];
        String[] answers = new String[questions.length];
        Random rnd = new Random();

        for (int i = 0; i < questions.length; i++) {
            int leftOperand = Utils.getRandomInt(0, 100);
            int rightOperand = Utils.getRandomInt(0, 100);
            String operator = OPERATORS[rnd.nextInt(0, OPERATORS.length)];
            String statement = leftOperand + " " + operator + " " + rightOperand;
            questions[i] = statement;
            try {
                answers[i] = String.valueOf(resolveStatement(leftOperand, rightOperand, operator));
            } catch (Error err) {
                System.out.println(err.getMessage());
            }
        }
        Engine.execute(ruleMessage, questions, answers);
    }
}
