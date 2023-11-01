package hexlet.code;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Strongly focused utility class.
 */
public class FileParser {
    private static final String PATH = "resources/primeNumbers";

    /**
     * Method returning a list of prime numbers read from a file.
     * @param requestedNumCount  Max returned numbers count
     * @return List of strings, where element is prime number in string format
     * @throws IOException  if I/O error occurs
     */
    public static List<String> getPrimeNumbers(int requestedNumCount) throws IOException {

        List<String> result = new ArrayList<>();
        byte[] textArr = Files.readAllBytes(Paths.get(PATH));
        String text = new String(textArr, StandardCharsets.ISO_8859_1);
        String[] splitText = text.split(",");
        int i = 0;
        while (i < requestedNumCount && i < splitText.length) { //if .lenght < requestedNumCount
            result.add(splitText[i].trim());
            i++;
        }
        return result;
    }
}
