package hexlet.code.abstracts;

import java.util.Random;
import java.util.Scanner;

/**
 * Game abstract class.
 */
public abstract class GameBase {
    private final Scanner scanner;
    private String name;
    private int successCount;
    private final int maxRandom = 100; //upper random border
    private final int minRandom = 1; //lower random border
    private final int maxSuccesses = 3; //max success attempts count
    private final Random random;

    /**
     * Parameterized parental cctor.
     * @param scannerRef Standard console input ref object
     */
    protected GameBase(Scanner scannerRef) {
        this.scanner = scannerRef;
        this.successCount = 0;
        this.random = new Random();
    }

    /**
     * Start Game contract method.
     * @param userName Name entered by user
     */
    public abstract void start(String userName);

    /**
     * Contract handler for user input in game.
     * @param suggestion user entered answer
     * @param number correct answer
     * @param count current success attempts counter
     * @return Increment @count if @suggestion is correct, -1 otherwise
     */
    public abstract int handleSuggestion(String suggestion, int number, int count);

    /**
     * Non-overridable Scanner object ref getter.
     * @return Scanner object
     */
    public final Scanner getScanner() {
        return scanner;
    }
    public final String getName() {
        return name;
    }

    public final int getSuccessCount() {
        return successCount;
    }

    public final int getMaxRandom() {
        return maxRandom;
    }

    public final int getMinRandom() {
        return minRandom;
    }

    public final int getMaxSuccesses() {
        return maxSuccesses;
    }

    public final Random getRandom() {
        return random;
    }

    public final void setName(String name) {
        this.name = name;
    }
    public final void setSuccessCount(int successes) {
        this.successCount = successes;
    }
}
