package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n 2 - Even\n 3 - Calc\n 0 - Exit\n");

        var choice = scanner.nextLine();

        System.out.println("Your choice: " + choice);

        switch (choice) {
            case ("1"): //greet message
                var simpleGreeter = new Greeter(scanner);
                break;
            case ("2"): //Even game choice
                var evenGameGreeter = new Greeter(scanner);
                var evenGame = new Even(evenGameGreeter.getName(), scanner);
                evenGame.start();
                break;
            case ("3"): //Calc game choice
                var calcGameGreeter = new Greeter(scanner);
                var calcGame = new Calc(calcGameGreeter.getName(), scanner);
                calcGame.start();
                break;
            default: //Exit choice or unexpected input string
                break;
        }
    }
}
