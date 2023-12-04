package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Calc {
    private static final String[] OPERATORS = new String[] {"-", "+", "*"};

    private static int resolveEquation(int leftOperand, int rightOperand, String operator) {
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
        List<Map<String, String>> gameDataCollection = new ArrayList<>(Engine.MAX_SUCCESSES_COUNT);

        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int leftOperand = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            int rightOperand = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String operator = OPERATORS[Utils.getRandomInt(0, OPERATORS.length)];
            String question = leftOperand + " " + operator + " " + rightOperand;
            String correctAnswer = String.valueOf(resolveEquation(leftOperand, rightOperand, operator));
            Map<String, String> gameData = new HashMap<>();
            gameData.put("question", question);
            gameData.put("answer", correctAnswer);
            gameDataCollection.add(gameData);
        }
        Engine.execute(ruleMessage, gameDataCollection);
    }
}
