package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, String> gameData = new HashMap<>(Engine.MAX_SUCCESSES_COUNT);

        for (int i = 0; i < Engine.MAX_SUCCESSES_COUNT; i++) {
            int leftOperand = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            int rightOperand = Utils.getRandomInt(Engine.MIN_RANDOM_INT, Engine.MAX_RANDOM_INT);
            String statement = leftOperand + " " + rightOperand;
            int solution = resolveStatement(leftOperand, rightOperand);
            String answer = String.valueOf(solution);
            gameData.put(statement, answer);
        }
        Engine.execute(rules, gameData);
    }


}
