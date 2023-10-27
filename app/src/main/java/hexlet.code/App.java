package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var greeter = new Greeter(scanner);

        System.out.println("Please enter the game number and press Enter.");
        System.out.print("1 - Greet\n 2 - Even\n 0 - Exit\n");

        var choice = scanner.nextLine();

        System.out.println("Your choice: " + choice);

        switch (choice) {
            case ("1"): //greet message
                greeter.greet();
                break;
            case ("2"): //Even game choice
                greeter.greet();
                var evenGame = new Even(greeter.getName(), scanner);
                evenGame.start();
                break; //Exit choice or unexpected input string
            default:
                break;
        }
    }
}
