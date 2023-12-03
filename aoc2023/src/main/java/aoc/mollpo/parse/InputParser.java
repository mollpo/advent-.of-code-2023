package aoc.mollpo.parse;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputParser {
    public static List<Integer> parseIntsFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        List<Integer> ints = new ArrayList<>();
        while (scanner.hasNextInt()) {
            ints.add(scanner.nextInt());
        }
        return ints;
    }

    public static List<String> parseStringsFromFile(String filename) throws FileNotFoundException {
        ClassLoader classLoader = InputParser.class.getClassLoader();

        File file = new File(classLoader.getResource(filename).getFile());
        Scanner scanner = new Scanner(file);
        List<String> strings = new ArrayList<>();
        while (scanner.hasNextLine()) {
            strings.add(scanner.nextLine());
        }
        return strings;
    }


}
