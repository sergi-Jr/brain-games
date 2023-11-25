package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
        List<Map<String, String>> gameData = new ArrayList<>(Engine.MAX_SUCCESSES_COUNT);

        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int questionNumber = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String question = String.valueOf(questionNumber);
            String answer = getAnswer(questionNumber) ? "yes" : "no";
            Map<String, String> dataPair = new HashMap<>(1);
            dataPair.put(question, answer);
            gameData.add(dataPair);
        }
        Engine.execute(ruleMessage, gameData);
    }
}
