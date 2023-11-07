package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

/**
 * Class provides "Even" game logic, consisting in providing the user with
 * the opportunity to answer the question about the parity of the number.
 */
public final class Even {
    private static String getAnswer(int statement) {
        return statement % 2 == 0 ? "yes" : "no";
    }
    public static void start() {
        String ruleMessage = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = new String[Engine.MAX_SUCCESSES_COUNT];
        String[] answers = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            int questionNumber = Utils.getRandomInt(0, 100);
            questions[i] = String.valueOf(questionNumber);
            answers[i] = getAnswer(questionNumber);
        }
        Engine.execute(ruleMessage, questions, answers);
    }
}

