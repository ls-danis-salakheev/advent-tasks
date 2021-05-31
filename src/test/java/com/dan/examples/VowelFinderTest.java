package com.dan.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VowelFinderTest {

    final String[] text = {"James"};

    @Test
    void shouldReturnTwoVowels() {
        Integer[] letterCount = VowelFinder.getVowelLetterCount(text);

        Assertions.assertEquals(letterCount[0], 2);
    }
}