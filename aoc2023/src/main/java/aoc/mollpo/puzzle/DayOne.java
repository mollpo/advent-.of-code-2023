package aoc.mollpo.puzzle;

import aoc.mollpo.parse.InputParser;

import java.io.FileNotFoundException;
import java.util.List;

public class DayOne {
    public static int partOne() throws FileNotFoundException {
        List<String> input = InputParser.parseStringsFromFile("day1.txt");
        int result = 0;
        for (String s : input) {
            String first = null;
            String last = null;
            for (int i = 0; i < s.length(); i++) {
                if (first == null && (Character.isDigit(s.charAt(i)) || getCharDigit(s.substring(i)) != null)) {
                    if (Character.isDigit(s.charAt(i))) {
                        first = String.valueOf(s.charAt(i));
                        last = String.valueOf(s.charAt(i));
                    } else {
                        var digit = getCharDigit(s.substring(i));
                        first = digit;
                        last = digit;
                    }
                } else if (Character.isDigit(s.charAt(i)) || getCharDigit(s.substring(i)) != null) {
                    last = Character.isDigit(s.charAt(i)) ? String.valueOf(s.charAt(i)) : getCharDigit(s.substring(i));
                }
            }

            result += Integer.parseInt(first + last);
        }
        return result;
    }

    private static String getCharDigit(String substring) {
        if (substring.startsWith("one")) {
            return "1";
        }
        if (substring.startsWith("two")) {
            return "2";
        }
        if (substring.startsWith("three")) {
            return "3";
        }
        if (substring.startsWith("four")) {
            return "4";
        }
        if (substring.startsWith("five")) {
            return "5";
        }
        if (substring.startsWith("six")) {
            return "6";
        }
        if (substring.startsWith("seven")) {
            return "7";
        }
        if (substring.startsWith("eight")) {
            return "8";
        }
        if (substring.startsWith("nine")) {
            return "9";
        }
        return null;
    }
}

