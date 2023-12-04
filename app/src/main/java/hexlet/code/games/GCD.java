package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GCD {

    private static String getAnswer(int leftOperand, int rightOperand) {
        int greaterOperand = Math.max(leftOperand, rightOperand);
        int lessOperand = Math.min(leftOperand, rightOperand);

        while (lessOperand != 0) {
            int temp = greaterOperand % lessOperand;
            greaterOperand = lessOperand;
            lessOperand = temp;
        }
        return String.valueOf(greaterOperand);
    }

    public static void start() {
        String ruleMessage = "Find the greatest common divisor of given numbers.";
        List<Map<String, String>> gameDataCollection = new ArrayList<>(Engine.MAX_SUCCESSES_COUNT);

        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int leftOperand = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            int rightOperand = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String question = leftOperand + " " + rightOperand;
            String correctAnswer = getAnswer(leftOperand, rightOperand);
            Map<String, String> gameData = new HashMap<>();
            gameData.put("question", question);
            gameData.put("answer", correctAnswer);
            gameDataCollection.add(gameData);
        }
        Engine.execute(ruleMessage, gameDataCollection);
    }
}
