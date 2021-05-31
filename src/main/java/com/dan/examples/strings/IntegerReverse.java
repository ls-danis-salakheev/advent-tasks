package com.dan.examples.strings;

import static com.dan.examples.strings.StringReverse.swap;

public class IntegerReverse {
    public static void main(String[] args) {

        int x = 1534236469;

        System.out.println(new Solution().reverse(x));
    }
}

class Solution {

    public int reverse(int x) {

        if (x >= Integer.MAX_VALUE - 1) return 0;

        if (x == 0) return 0;

        char[] chars = Long.toString(x).toCharArray();

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            if (!Character.isDigit(chars[i])) i++;

            if (j == chars.length - 1) {
                if (chars[j] == 0)
                    break;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        int result;
        try {
            result = Integer.parseInt(String.valueOf(chars));
        } catch (NumberFormatException e) {
            return 0;
        }
        return result;
    }
}
