package hexlet.code.games;

import hexlet.code.abstracts.GameBase;

import java.util.Scanner;

public class Progression extends GameBase {
    private final int PROGRESSION_LENGTH = 10; //max numbers count in progression
    /**
     * Parameterized parental cctor
     *
     * @param scanner Standard console input ref object
     */
    public Progression(Scanner scanner) {
        super(scanner);
    }

    @Override
    public void start(String name) {
        this.name = name;


        System.out.println("What number is missing int the progression?");

        while (this.successCount < MAX_SUCCESS_COUNT && this.successCount >= 0) {
            int progressionIncrement = random.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM + 1);
            int progressionStartValue = random.nextInt(MIN_RANDOM_NUM, MAX_RANDOM_NUM + 1);
            int missingValuePosition = random.nextInt(0, PROGRESSION_LENGTH);
            int solution = progressionStartValue + missingValuePosition * progressionIncrement;

            showProgression(progressionStartValue, progressionIncrement, missingValuePosition);
            System.out.print("Your answer: ");
            String userSuggestion = scanner.nextLine();

            this.successCount = handleSuggestion(userSuggestion, solution, this.successCount);
        }
        if(this.successCount == MAX_SUCCESS_COUNT) {
            System.out.println("Congratulations, " + name + "!");
        }
    }

    @Override
    public int handleSuggestion(String suggestion, int number, int count) {
        if (suggestion.equals(String.valueOf(number))) {
            System.out.println("Correct!");
            return ++count;
        }
        System.out.println("'" + suggestion + "' " + "is wrong answer ;(. " +
                "Correct answer was " + number);
        System.out.println("Let's try again, " + name + "!");
        count = -1;
        return count;
    }

    /**
     * Local method shows arithmetic progression randomly generated by parameters
     * @param start First progression number
     * @param increment Progression step
     * @param position Position of element that must be replaced by dots in output
     */
    private void showProgression(int start, int increment, int position) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < PROGRESSION_LENGTH; i++) {
            var currentSymbolToOutput = i == position ? ".." : start;
            output.append(currentSymbolToOutput).append(" ");
            start += increment;
        }
        System.out.println(output);
    }
}