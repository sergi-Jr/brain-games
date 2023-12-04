package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Progression {
    private static final int PROGRESSION_LENGTH = 10;

    private static String[] getQuestion(int start, int increment, int progressionLength) {
        String[] result = new String[progressionLength];
        for (int i = 0; i < progressionLength; i++) {
            result[i] = String.valueOf(start);
            start += increment;
        }
        return result;
    }

    public static void start() {
        String ruleMessage = "What number is missing in the progression?";
        List<Map<String, String>> gameDataCollection = new ArrayList<>(Engine.MAX_SUCCESSES_COUNT);

        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int progressionIncrement = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            int progressionStartValue = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            int missingValuePosition = Utils.getRandomInt(0, PROGRESSION_LENGTH);
            String[] progressArr =
                    getQuestion(progressionStartValue, progressionIncrement, PROGRESSION_LENGTH);
            progressArr[missingValuePosition] = "..";
            String question = String.join(" ", progressArr);
            int solution = progressionStartValue + missingValuePosition * progressionIncrement;
            String correctAnswer = String.valueOf(solution);
            Map<String, String> gameData = new HashMap<>();
            gameData.put("question", question);
            gameData.put("answer", correctAnswer);
            gameDataCollection.add(gameData);
        }
        Engine.execute(ruleMessage, gameDataCollection);
    }
}
