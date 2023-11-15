package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> gameData = new HashMap<>(Engine.MAX_SUCCESSES_COUNT);

        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int leftOperand = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            int rightOperand = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String operator = OPERATORS[Utils.getRandomInt(0, OPERATORS.length)];
            String statement = leftOperand + " " + operator + " " + rightOperand;
            try {
                String answer = String.valueOf(resolveStatement(leftOperand, rightOperand, operator));
                gameData.put(statement, answer);
            } catch (Error err) {
                System.out.println(err.getMessage());
            }
        }
        Engine.execute(ruleMessage, gameData);
    }
}
