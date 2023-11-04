package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

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
    public static void start(Scanner scanner) {
        String rules = "Find the greatest common divisor of given numbers.";
        String[] questions = new String[Engine.getMaxSuccessesCount()];
        String[] answers = new String[questions.length];
        for (int i = 0; i < questions.length; i++) {
            int leftOperand = Engine.getRandomNumber();
            int rightOperand = Engine.getRandomNumber();
            String statement = leftOperand + " " + rightOperand;
            questions[i] = statement;
            int solution = resolveStatement(leftOperand, rightOperand);
            answers[i] = String.valueOf(solution);
        }
        Engine.execute(scanner, rules, questions, answers);
    }


}
