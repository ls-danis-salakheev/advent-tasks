package com.dan.examples.vowels;

import kotlin.Pair;

import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

public class VowelFinder {

    static final char[] VOWELS = {'a', 'e', 'i', 'u', 'o'};

    public static void main(String[] args) {

        String[] strings = {"James", "alex", "Moscow", "RUSSIA", "java", "123bc"};

        var vov = getVowelLetterCount(strings);

        System.out.println(Arrays.toString(vov));

    }

    public static Integer[] getVowelLetterCount(String[] strings) {
        return Arrays.stream(strings)
                .map(s -> s.toLowerCase().toCharArray())
                .flatMap(chArr -> Stream.of(getVowels(chArr)))
                .map(List::size)
                .toArray(Integer[]::new);
    }

    private static List<Character> getVowels(char[] chars) {

        List<Character> characters = new ArrayList<>();

        for (char c : chars) {
            if (c == VOWELS[0] || c == VOWELS[1] || c == VOWELS[2] || c == VOWELS[3] || c == VOWELS[4]) {
                characters.add(c);
            }
        }
        return characters;
    }

}
