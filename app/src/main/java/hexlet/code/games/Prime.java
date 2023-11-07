package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

/**
 * Prime game class.
 */
public final class Prime {
    public static void start() {
        String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[] questions = new String[Engine.MAX_SUCCESSES_COUNT];
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            int currentRnd = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            questions[i] = String.valueOf(currentRnd);
            answers[i] = resolveStatement(currentRnd);
        }
        Engine.execute(rules, questions, answers);
    }

    /**
     * Method determines that number is prime.
     * @param questNum Question randomly generated number
     * @return 0 if number is not prime, 1 otherwise
     */
    private static String resolveStatement(int questNum) {
        if (questNum < 2) {
            return "no";
        }
        for (int i = 2; i <= questNum / 2; i++) {
            if (questNum % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
