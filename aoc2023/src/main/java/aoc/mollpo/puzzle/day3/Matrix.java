package aoc.mollpo.puzzle.day3;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class Matrix {
    private char[][] matrix;

    public Matrix(List<String> input) {
        matrix = new char[input.size()][input.get(0).length()];
        for (int i = 0; i < input.size(); i++) {
            matrix[i] = input.get(i).toCharArray();
        }
    }

    public Pair<Boolean, Integer> getNumberIfValid(int i, int j) {
        StringBuilder number = new StringBuilder();
        number.append(matrix[i][j]);
        boolean isValid = false;
        if (i > 0) {
            if (!Character.isDigit(matrix[i - 1][j]) && '.' != matrix[i - 1][j]) {
                isValid = true;
            }
        }
        if (i < matrix.length - 1) {
            if (!Character.isDigit(matrix[i + 1][j]) && '.' != matrix[i + 1][j]) {
                isValid = true;
            }
        }
        if (i > 0 && j > 0) {
            if (!Character.isDigit(matrix[i - 1][j - 1]) && '.' != matrix[i - 1][j - 1]) {
                isValid = true;
            }
        }

        if (i < matrix.length - 1 && j < matrix[i].length - 1) {
            if (!Character.isDigit(matrix[i + 1][j + 1]) && '.' != matrix[i + 1][j + 1]) {
                isValid = true;
            }
        }
        if (i > 0 && j < matrix[i].length - 1) {
            if (!Character.isDigit(matrix[i - 1][j + 1]) && '.' != matrix[i - 1][j + 1]) {
                isValid = true;
            }
        }
        if (i < matrix.length - 1 && j > 0) {
            if (!Character.isDigit(matrix[i + 1][j - 1]) && '.' != matrix[i + 1][j - 1]) {
                isValid = true;
            }
        }
        if (j > 0) {
            if (!Character.isDigit(matrix[i][j - 1]) && '.' != matrix[i][j - 1]) {
                isValid = true;
            }
        }
        if (j < matrix[i].length - 1) {
            if (!Character.isDigit(matrix[i][j + 1]) && '.' != matrix[i][j + 1]) {
                isValid = true;
            }
        }
        if (j > 0) {
            int columRight = j;
            while (Character.isDigit(matrix[i][columRight - 1])) {
                number.insert(0, matrix[i][columRight - 1]);
                --columRight;
                if (columRight == 0) {
                    break;
                }
            }
        }
        if (j < matrix[i].length - 1) {
            int columLeft = j;
            while (Character.isDigit(matrix[i][columLeft + 1])) {
                number.append(matrix[i][columLeft + 1]);
                columLeft++;
                if (columLeft == matrix[i].length - 1) {
                    break;
                }
            }
        }
        return Pair.of(isValid, Integer.parseInt(number.toString()));
    }

    public char[][] getMatrix() {
        return matrix;
    }

}
