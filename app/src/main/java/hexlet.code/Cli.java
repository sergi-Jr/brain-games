package hexlet.code;


import java.util.Scanner;

public final class Cli {
    private static Scanner scanner;
    static {
        scanner = new Scanner(System.in);
    }
    public static void helloMessage() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
    }
    public static String chooseGameMessage() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n 2 - Even\n 0 - Exit");

        var input = scanner.nextLine();
        System.out.println("Your choice: " + input);
        return input;
    }
}
