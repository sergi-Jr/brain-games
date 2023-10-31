package hexlet.code.abstracts;

import java.util.Random;
import java.util.Scanner;

/**
 * Game abstract class
 */
public abstract class GameBase {
    protected Scanner scanner;
    protected String name;
    protected int successCount;
    protected final int MAX_RANDOM_NUM = 100; //upper random border
    protected final int MIN_RANDOM_NUM = 1; //lower random border
    protected final int MAX_SUCCESS_COUNT = 3; //max success attempts count
    protected Random random;

    /**
     * Parameterized parental cctor
     * @param scanner Standard console input ref object
     */
    protected GameBase(Scanner scanner) {
        this.scanner = scanner;
        this.successCount = 0;
        this.random = new Random();
    }
    /**
     * start Game contract method
     */
    public abstract void start(String name);

    /**
     * Contract handler for user input in game
     * @param suggestion user entered answer
     * @param number correct answer
     * @param count current success attempts counter
     * @return Increment @count if @suggestion is correct, -1 otherwise
     */
    public abstract int handleSuggestion(String suggestion, int number, int count);

    /**
     * Scanner object ref non-overridable getter
     * @return Scanner object
     */
    public final Scanner getScanner() {
        return scanner;
    }
}
