package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Prime {

    public static void start() {
        String ruleMessage = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        List<Map<String, String>> gameDataCollection = new ArrayList<>(Engine.MAX_SUCCESSES_COUNT);
        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int currentRnd = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String question = String.valueOf(currentRnd);
            String correctAnswer = isPrime(currentRnd) ? "yes" : "no";
            Map<String, String> gameData = new HashMap<>();
            gameData.put("question", question);
            gameData.put("answer", correctAnswer);
            gameDataCollection.add(gameData);
        }
        Engine.execute(ruleMessage, gameDataCollection);
    }

    private static boolean isPrime(int questNum) {
        if (questNum < 2) {
            return false;
        }
        for (int i = 2; i <= questNum / 2; i++) {
            if (questNum % i == 0) {
                return false;
            }
        }
        return true;
    }
}
