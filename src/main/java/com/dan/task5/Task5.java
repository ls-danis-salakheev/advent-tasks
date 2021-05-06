package com.dan.task5;

import com.dan.runner.Runner;
import com.dan.task5.exception.BoardingPassesNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Task5 implements Runner {

    private static final int SEAT_OFFSET = 3;
    private static final String regExPattern = "[FBLR]{10}";

    private final List<String> INPUT;

    public Task5(String filePath) {
        Path aPath = Paths.get(filePath);
        try {
            INPUT = Files.lines(aPath)
                    .filter(it -> Pattern.compile(regExPattern).matcher(it).matches())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new BoardingPassesNotFoundException("File not found. Please, check the input path. Make sure that the file is in the root of the resources folder.");
        }
    }

    public Task5() {
        INPUT = new ArrayList<>() {{
            add("BFFFBBFRRR");
            add("FFFBBBFRRR");
            add("FBFBBFFRLR");
        }};
    }

    public Set<BoardingPass> parse() {
        Set<BoardingPass> passes = new TreeSet<>();

        for (String str : INPUT) {

            char[] chars = str.toCharArray();

            var pass = new BoardingPass();

            if (chars[0] == 'F') { // 0 --- 127
                pass.maxRow /= 2;
            } else pass.minRow = pass.maxRow / 2;

            for (int i = 1; i < chars.length - SEAT_OFFSET; i++) {
                if (chars[i] == 'F') {
                    pass.maxRow -= (pass.maxRow - pass.minRow) / 2;
                }
                if (chars[i] == 'B') {
                    pass.minRow += (pass.maxRow - pass.minRow) / 2;
                }
            }
            if (chars[6] == 'F') {
                pass.finalRow = pass.minRow;
            } else pass.finalRow = pass.maxRow;

            if (chars[7] == 'R') {
                pass.minSeat = pass.maxSeat / 2;
            } else pass.maxSeat /= 2;

            if (chars[8] == 'R') {
                pass.minSeat += (pass.maxSeat - pass.minSeat) / 2;
            } else pass.maxSeat -= (pass.maxSeat - pass.minSeat) / 2;

            if (chars[9] == 'R') {
                pass.finalSeat = pass.maxSeat;
            } else pass.finalSeat = pass.minSeat;

            passes.add(pass);
        }

        return passes;
    }

    static final class BoardingPass implements Comparable<BoardingPass> {
        int minRow = 0;
        int maxRow = 128;
        int minSeat = 0;
        int maxSeat = 7;

        int finalRow;
        int finalSeat;

        public BoardingPass() {
        }

        @Override
        public String toString() {
            return "BoardingPass with" +
                    " row=" + finalRow +
                    " and seat=" + finalSeat;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BoardingPass that = (BoardingPass) o;

            if (finalRow != that.finalRow) return false;
            return finalSeat == that.finalSeat;
        }

        @Override
        public int hashCode() {
            int result = finalRow;
            result = 31 * result + finalSeat;
            return result;
        }

        @Override
        public int compareTo(@NotNull BoardingPass o) {
            return Integer.compare(this.hashCode(), o.hashCode());
        }
    }

    @Override
    public void runner() throws Exception {
        this.parse().forEach(System.out::println);
    }
}
