package hexlet.code;

import java.util.Scanner;
/**
 * User greeting utility class.
 */
public final class Greeter {
    private static String name;
    /**
     * Local username request method.
     */
    public static void greet() {
        Scanner inputScanner = new Scanner(System.in);
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
