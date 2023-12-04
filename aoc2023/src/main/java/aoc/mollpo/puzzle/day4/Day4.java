package aoc.mollpo.puzzle.day4;

import aoc.mollpo.parse.InputParser;
import org.apache.commons.lang3.tuple.Pair;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Day4 {
    public static int solvePartOne() throws FileNotFoundException {
        Collection<ScratchCard> cards = parseCards();
        int result = 0;
        for (ScratchCard card : cards) {
            long value = card.scratchCard().getRight().stream().filter(card.scratchCard().getLeft()::contains).count();
            result += value == 0 ? 0 : (int) Math.pow(2, value - 1);
        }

        return result;
    }

    public static int solvePartTwo() throws FileNotFoundException {
        List<ScratchCard> cards = parseCards();
        int result = 0;
        int[] cardAmount = new int[cards.size()];
        Arrays.fill(cardAmount, 1);
        for (int i = 0; i < cards.size(); i++) {
            long value = cards.get(i).scratchCard().getRight().stream().filter(cards.get(i).scratchCard().getLeft()::contains).count();
            for (int j = 0; j < value && j + i + 1 < cards.size(); j++) {
                cardAmount[j + 1 + i] += cardAmount[i];
            }
        }
        return Arrays.stream(cardAmount).sum();
    }

    private static List<ScratchCard> parseCards() throws FileNotFoundException {
        Collection<String> input = InputParser.parseStringsFromFile("day4.txt");
        List<ScratchCard> cards = new ArrayList<>();
        input.forEach(s -> {
            String[] values = s.substring(s.indexOf(":") + 1).split("\\|");
            cards.add(new ScratchCard(Pair.of(Arrays.stream(values[0].trim().replace("  ", " ").split(" ")).map(String::trim)
                    .map(Integer::parseInt).toList(), Arrays.stream(values[1].trim().replace("  ", " ").split(" ")).map(Integer::parseInt).toList())));
        });
        return cards;
    }
}
