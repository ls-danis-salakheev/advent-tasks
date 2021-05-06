package com.dan.task8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * Initial data is
 * action   step
 * nop +0    0
 * acc +1    1
 * jmp +4    2
 * acc +3    3
 * jmp -3    4
 * acc -99   5
 * acc +1    6
 * jmp -4    7
 * acc +6    8
 */

public class Task8 {
    public static void main(String[] args) throws IOException {
        String nop = "nop";
        String acc = "acc";
        String jmp = "jmp";

        var input = Files
                .lines(Path.of("src/main/resources/task7.txt"))
                .map(s -> s.split(" "))
                .collect(Collectors.toList());

        int accum = 0;
        long start = 0;
        for (int i = 0, collectSize = input.size(); i < collectSize; i++) {
            if (input.get(i)[0].equals(nop)) {
                continue;
            }
            if (input.get(i)[0].equals(acc)) {
                accum += Integer.parseInt(input.get(i)[1]);
            }
            if (input.get(i)[0].equals(jmp)) {
                int suffix = Integer.parseInt(input.get(i)[1]);

                if (suffix > 0) {
                    suffix--;
                    i += suffix;
                } else {
                    i += suffix;
                    i--;
                }
                if (accum == 5) {
                    start = System.currentTimeMillis();
                }

                long finish = System.currentTimeMillis() - start;
                if (finish == 1000) {
                    System.out.println("Total accum for 1 sec is " + accum);
                    break;
                }
            }
        }
    }
}




