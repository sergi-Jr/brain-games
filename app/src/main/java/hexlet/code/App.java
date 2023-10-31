package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n0 - Exit\n");

        String choice = scanner.nextLine();

        System.out.println("Your choice: " + choice);

        switch (choice) {
            case ("1"): //greet message
                Greeter.greet(scanner);
                break;
            case ("2"): //Even game choice
                Even evenGame = new Even(scanner);
                Engine.execute(evenGame);
                break;
            case ("3"): //Calc game choice
                Calc calcGame = new Calc(scanner);
                Engine.execute(calcGame);
                break;
            case ("4"): //GCD game choice
                GCD gcdGame = new GCD(scanner);
                Engine.execute(gcdGame);
            case ("5"): //Progression game choice
                Progression progressionGame = new Progression(scanner);
                Engine.execute(progressionGame);
            default: //Exit choice or unexpected input string
                break;
        }
    }
}
