package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit\n");

        String choice = SCANNER.nextLine();

        System.out.println("Your choice: " + choice);
        gameSwitcher(choice);
    }

    /**
     * Method launches required game by user choice.
     * @param choice User entered choice
     */
    private static void gameSwitcher(String choice) {
        switch (choice) {
            case ("1"): //greet message
                Greeter.greet(SCANNER);
                break;
            case ("2"): //Even game choice
                Even.start(SCANNER);
                break;
            case ("3"): //Calc game choice
                Calc.start(SCANNER);
                break;
            case ("4"): //GCD game choice
                GCD.start(SCANNER);
                break;
            case ("5"): //Progression game choice
                Progression.start(SCANNER);
                break;
            case ("6"): //Prime game choice
                Prime.start(SCANNER);
                break;
            default: //Exit choice or unexpected input string
                break;
        }
    }
}
