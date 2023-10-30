package hexlet.code.abstracts;

import java.util.Scanner;

/**
 * Initiation abstract class
 */
public abstract class InitBase {
    protected Scanner scanner;
    protected String name;

    /**
     * Parameterized parental cctor
     * @param scanner Standard console input ref object
     */
    protected InitBase(Scanner scanner) {
        this.scanner = scanner;
    }
    /**
     * Parameterized parental cctor
     * @param name name entered by user
     * @param scanner Standard console input ref object
     */
    protected InitBase(String name, Scanner scanner) {
        this.name = name;
        this.scanner = scanner;
    }

    /**
     * Name field getter
     * @return Name field
     */
    public String getName() {
        return name;
    }
}
