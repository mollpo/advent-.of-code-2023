package aoc.mollpo.puzzle.day3;

import aoc.mollpo.parse.InputParser;
import org.apache.commons.lang3.tuple.Pair;

import java.io.FileNotFoundException;
import java.util.List;

public class Day3 {
    public static int solvePartOne() throws FileNotFoundException {
        Matrix input = new Matrix(InputParser.parseStringsFromFile("day3.txt"));
        char[][] matrix = input.getMatrix();
        int result = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (Character.isDigit(matrix[i][j])) {
                    Pair<Boolean, Integer> numberIfValid = input.getNumberIfValid(i, j);
                    if (numberIfValid.getLeft()) {
                        result += numberIfValid.getRight();
                        System.out.println(numberIfValid.getRight());
                        while (j < matrix[i].length && Character.isDigit(matrix[i][j])) {
                            j++;
                        }
                        --j;
                    }
                }
            }
        }
        return result;
    }

    private static char[][] createMatrix(List<String> input) {
        char[][] matrix = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            matrix[i] = input.get(i).toCharArray();
        }
        return matrix;
    }
}
