package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

/**
 * Class provides "Greater common divisor" (GCD) game logic.
 * Consists in providing the user with the opportunity to answer the question about the finding greater common divisor
 */
public final class GCD {
    /**
     * Local method to resolve math expression.
     * @param leftOperand expression Left operand
     * @param rightOperand  expression Right  operand
     * @return Statement solution
     */
    private static int resolveStatement(int leftOperand, int rightOperand) {
        int greaterOperand = Math.max(leftOperand, rightOperand);
        int lessOperand = Math.min(leftOperand, rightOperand);

        while (lessOperand != 0) {
            int temp = greaterOperand % lessOperand;
            greaterOperand = lessOperand;
            lessOperand = temp;
        }
        return greaterOperand;
    }
    public static void start() {
        String rules = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[Engine.MAX_SUCCESSES_COUNT];
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            int leftOperand = Utils.getRandomInt(0, 100);
            int rightOperand = Utils.getRandomInt(0, 100);
            String statement = leftOperand + " " + rightOperand;
            questions[i] = statement;
            int solution = resolveStatement(leftOperand, rightOperand);
            answers[i] = String.valueOf(solution);
        }
        Engine.execute(rules, questions, answers);
    }


}
