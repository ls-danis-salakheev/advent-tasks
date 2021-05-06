package com.dan.task8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Task8 {
    public static void main(String[] args) throws IOException {
        String nop = "nop";
        String acc = "acc";
        String jmp = "jmp";

        var collect = Files
                .lines(Path.of("src/main/resources/task7.txt"))
                .map(s -> s.split(" "))
                .collect(Collectors.toList());
        collect.forEach(strings -> System.out.println(Arrays.toString(strings)));

//        int i = 10;
//        String s = "-4";
//        String s2 = "+5";
//
//        System.out.println(Integer.parseInt(s2) + i);
//
//        String s1 = collect.get(1)[1];
//        System.out.println(Integer.parseInt(s) + i);

        int cycle = 0;
        int accum = 0;
        for (int i = 0, collectSize = collect.size(); i < collectSize; i++) {
            if (collect.get(i)[0].equals(nop)) {
                continue;
            }
            if (collect.get(i)[0].equals(acc)) {
                accum += Integer.parseInt(collect.get(i)[1]);
            }
            if (collect.get(i)[0].equals(jmp)) {
                i += Integer.parseInt(collect.get(i)[1]);
                if (collect.get(i)[1].equals("-4")) {
                    cycle++;
                }
            }
            if (cycle == 2) {
                return;
            }
        }

        System.out.println(accum);

    }
}




