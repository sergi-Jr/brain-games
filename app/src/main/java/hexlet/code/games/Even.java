package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

/**
 * Class provides "Even" game logic, consisting in providing the user with
 * the opportunity to answer the question about the parity of the number.
 */
public final class Even {
    public static void start(Scanner scanner) {
        String ruleMessage = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questions = new String[Engine.getMaxSuccessesCount()];
        String[] answers = new String[questions.length];

        for (int i = 0; i < questions.length; i++) {
            int questionNumber = Engine.getRandomNumber();
            questions[i] = String.valueOf(questionNumber);
            answers[i] = questionNumber % 2 == 0 ? "yes" : "no";
        }
        Engine.execute(scanner, ruleMessage, questions, answers);
    }
}

