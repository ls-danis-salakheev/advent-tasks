package com.dan.examples.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringReverse {

    public static void main(String[] args) {

        char[] s = {'H','a','n','n','a','h'};

        int i = 0;
        int j = s.length - 1;

        while(i<j) {
            swap(s, i, j);
            i++;
            j--;
        }
        System.out.println(s);
    }

    public static void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

}
