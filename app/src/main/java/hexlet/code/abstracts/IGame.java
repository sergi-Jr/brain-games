package hexlet.code.abstracts;

import java.util.List;

/**
 * Contract Game types methods
 */
public interface IGame {
    /**
     * start Game contract method
     */
    void start();

    /**
     * Handler for user input in game
     * @param suggestion user entered answer
     * @param number correct answer
     * @param count current success attempts counter
     * @return Increment @count if @suggestion is correct, -1 otherwise
     */
    int handleSuggestion(String suggestion, int number, int count);
}
