package hexlet.code.abstracts;

import java.util.Random;
import java.util.Scanner;

/**
 * Game abstract class
 */
public abstract class GameBase extends InitBase {
    protected final int MAX_RANDOM_NUM = 100; //upper random border
    protected final int MIN_RANDOM_NUM = 1; //lower random border
    protected final int MAX_SUCCESS_COUNT = 3; //max success attempts count
    protected Random random;

    /**
     * Parameterized parental cctor
     * @param name name entered by user
     * @param scanner Standard console input ref object
     */
    protected GameBase(String name, Scanner scanner) {
        super(name, scanner);
        this.random = new Random();
    }
}
