package com.dan.task2;

import com.dan.runner.Runner;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A base pattern to check with regex \d-\d\s[a-zA-Z]\W\s[a-zA-Z] using
 *
 * @see Pattern
 */

public class Task2 implements Runner {

    private List<String> input = List.of("1-6 a: abcaadaeaa", "1-2 b: cdefg", "2-9 c: ccccccc");

    public Task2() {
    }

    public Task2(String... customInput) {
        input = List.of(customInput);
    }

    @Override
    public void runner() {
        input.stream()
                .map(s -> s.split("\\W"))
                .map(arr -> new Pattern(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), arr[2], arr[4]))
                .collect(Collectors.toMap(Function.identity(), Pattern::isValid))
                .forEach((pattern, aBoolean) -> System.out.println(pattern + " to " + aBoolean));
    }
}
