package aoc.mollpo.puzzle.day2;

import aoc.mollpo.parse.InputParser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {

    public static int solvePart1() throws FileNotFoundException {
        Map<Integer, List<Game>> games = new Day2().parseInput();
        return games.entrySet().stream().filter(e -> e.getValue().stream()
                        .allMatch(g -> g.blue() <= 14 && g.red() <= 12 && g.green() <= 13))
                .mapToInt(Map.Entry::getKey).sum();
    }

    public static int solvePart2() throws FileNotFoundException {
        var games = new Day2().parseInput().values();
        int result = 0;
        for (var rounds : games) {
            int blueMax = rounds.stream().mapToInt(Game::blue).max().getAsInt();
            int redMax = rounds.stream().mapToInt(Game::red).max().getAsInt();
            int greenMax = rounds.stream().mapToInt(Game::green).max().getAsInt();
            result += blueMax * redMax * greenMax;
        }
        return result;
    }


    private Map<Integer, List<Game>> parseInput() throws FileNotFoundException {
        Map<Integer, List<Game>> result = new HashMap<>();
        for (String s : InputParser.parseStringsFromFile("C:\\GitRepos\\advent-.of-code-2023\\aoc2023\\src\\main\\resources\\day2.txt")) {
            String gamesString = s.substring(s.indexOf(":") + 1);
            String[] rounds = gamesString.split(";");
            List<Game> games = new ArrayList<>();
            for (String round : rounds) {
                String[] amountColorPair = round.split(",");
                int blue = 0;
                int red = 0;
                int green = 0;
                for (String pair : amountColorPair) {
                    String[] split = pair.trim().split(" ");
                    int amount = Integer.parseInt(split[0]);
                    switch (split[1]) {
                        case "blue" -> blue += amount;
                        case "red" -> red += amount;
                        case "green" -> green += amount;
                    }
                }
                games.add(new Game(blue, red, green));
            }
            result.put(result.size() + 1, games);
        }
        return result;
    }
}
