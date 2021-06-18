package com.dan.examples.strings.uniquechar;

import java.util.Arrays;
import java.util.List;

public class MainRunner {

    public static void main(String[] args) {

        String str = "leetcode";
        String str2 = "loveleetcode";


        char[] chars = str.toCharArray();
        char uniq = chars[0];

        for (int i = chars.length - 1; i > 1; i--) {
            for (int j = 0; j < i; j++) {
                if (chars[j] != chars[j + 1]) {
                    uniq = chars[j + 1];
                }
            }
        }

        System.out.println(uniq);
    }

}
