package hexlet.code;

import java.util.Random;

public class Utils {

    public static int getRandomInt(int lowerBorder, int upperBorder) {
        Random rnd = new Random();
        return rnd.nextInt(lowerBorder, upperBorder);
    }
}
