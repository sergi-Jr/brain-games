package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Prime game class.
 */
public final class Prime {
    public static void start() {
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        Map<String, String> gameData = new HashMap<>(Engine.MAX_SUCCESSES_COUNT);
        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int currentRnd = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String question = String.valueOf(currentRnd);
            String answer = resolveStatement(currentRnd) ? "yes" : "no";
            gameData.put(question, answer);
        }
        Engine.execute(rules, gameData);
    }

    /**
     * Method determines that number is prime.
     * @param questNum Question randomly generated number
     * @return 0 if number is not prime, 1 otherwise
     */
    private static boolean resolveStatement(int questNum) {
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
