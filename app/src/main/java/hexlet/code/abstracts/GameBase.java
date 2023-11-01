package hexlet.code.abstracts;

import java.util.Random;
import java.util.Scanner;

/**
 * Game abstract class.
 */
public abstract class GameBase {
    protected Scanner scanner;
    protected String name;
    protected int successCount;
    protected final int MAX_RANDOM = 100; //upper random border
    protected final int MIN_RANDOM = 1; //lower random border
    protected final int MAX_SUCCESSES = 3; //max success attempts count
    protected Random random;

    /**
     * Parameterized parental cctor.
     * @param scanner Standard console input ref object
     */
    protected GameBase(Scanner scanner) {
        this.scanner = scanner;
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
}
