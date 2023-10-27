package hexlet.code;

import java.util.Scanner;

/**
 * User greeting class
 */
public final class Greeter {
    private String name;
    private Scanner scanner;

    /**
     * Parameterized class cctor
     * @param scanner Standard console input object ref
     */
    public Greeter(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Method greets user and sets name field
     */
    public void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }

    /**
     * Get name field
     * @return name field
     */
    public String getName() {
        return name;
    }
}
