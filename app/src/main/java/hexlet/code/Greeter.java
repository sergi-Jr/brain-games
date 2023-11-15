package hexlet.code;

import java.util.Scanner;
/**
 * User greeting utility class.
 */
public final class Greeter {
    /**
     * Local username request method.
     */
    public static void greet() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = inputScanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
