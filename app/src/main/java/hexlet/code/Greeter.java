package hexlet.code;

import java.util.Scanner;

public final class Greeter {

    public static void greet() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = inputScanner.nextLine();
        System.out.println("Hello, " + name + "!");
        inputScanner.close();
    }
}
