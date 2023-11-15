package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Class provides "Even" game logic, consisting in providing the user with
 * the opportunity to answer the question about the parity of the number.
 */
public final class Even {
    private static boolean getAnswer(int statement) {
        return statement % 2 == 0;
    }
    public static void start() {
        String ruleMessage = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        Map<String, String> gameData = new HashMap<>(Engine.MAX_SUCCESSES_COUNT);

        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int questionNumber = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String question = String.valueOf(questionNumber);
            String answer = getAnswer(questionNumber) ? "yes" : "no";
            gameData.put(question, answer);
        }
        Engine.execute(ruleMessage, gameData);
    }
}

