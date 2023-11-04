package hexlet.code;

import java.util.Scanner;
/**
 * User greeting utility class.
 */
public final class Greeter {
    private static String name;
    /**
     * Local username request method.
     * @param inputScanner Standard user input reader
     */
    public static void greet(Scanner inputScanner) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        name = inputScanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
    /**
     * Username field getter.
     * @return Name field
     */
    public static String getName() {
        return name;
    }
}
