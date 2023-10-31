package hexlet.code;

import hexlet.code.abstracts.GameBase;

/**
 * Utility class provides games execution
 */
public class Engine {
    /**
     * Method that launches the game
     * @param game Abstract class GameBase object
     */
    public static void execute(GameBase game) {
        Greeter.greet(game.getScanner());
        game.start(Greeter.getName());
    }
}
