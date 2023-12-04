package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit\n");

        String choice = scanner.nextLine();

        System.out.println("Your choice: " + choice);
        gameSwitcher(choice);
        scanner.close();
    }

    private static void gameSwitcher(String choice) {
        switch (choice) {
            case ("1"): //greet message
                Greeter.greet();
                break;
            case ("2"): //Even game choice
                Even.start();
                break;
            case ("3"): //Calc game choice
                Calc.start();
                break;
            case ("4"): //GCD game choice
                GCD.start();
                break;
            case ("5"): //Progression game choice
                Progression.start();
                break;
            case ("6"): //Prime game choice
                Prime.start();
                break;
            default: //Exit choice or unexpected input string
                break;
        }
    }
}
