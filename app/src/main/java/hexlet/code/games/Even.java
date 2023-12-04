package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Even {

    private static boolean isEven(int statement) {
        return statement % 2 == 0;
    }

    public static void start() {
        String ruleMessage = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        List<Map<String, String>> gameDataCollection = new ArrayList<>(Engine.MAX_SUCCESSES_COUNT);

        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int questionNumber = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String question = String.valueOf(questionNumber);
            String correctAnswer = isEven(questionNumber) ? "yes" : "no";
            Map<String, String> gameData = new HashMap<>();
            gameData.put("question", question);
            gameData.put("answer", correctAnswer);
            gameDataCollection.add(gameData);
        }
        Engine.execute(ruleMessage, gameDataCollection);
    }
}
