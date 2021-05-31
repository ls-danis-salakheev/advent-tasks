package com.dan.task9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) throws IOException {
        var input = Files
                .lines(Path.of("src/main/resources/task9.txt"))
                .map(Integer::parseInt)
                .filter(it -> it != 127)
                .collect(Collectors.toList());

        int i = input.size() - 1;
        while (i >= 0) {
//            for (int j = i-1; j >= 0; j--) {
//                if()
//            }
            System.out.println(input.get(i));
            i--;
        }


    }
}
