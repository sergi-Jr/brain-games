package hexlet.code;

import hexlet.code.abstracts.InitBase;

import java.util.Scanner;

/**
 * User greeting class
 */
public final class Greeter extends InitBase {
    /**
     * Parameterized extended class cctor
     * @param scanner Standard console input object ref
     */
    public Greeter(Scanner scanner) {
        super(scanner);
        greet();
    }

    /**
     * Local username request method
     */
    private void greet() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
    }
}
