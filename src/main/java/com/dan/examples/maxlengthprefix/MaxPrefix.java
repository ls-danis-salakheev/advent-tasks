package com.dan.examples.maxlengthprefix;

public class MaxPrefix {

    public static void main(String[] args) {

        String[] arr = {
                "tester1",
                "test21",
                "testo777",
                "0test80"
        };

        String[] empty = {};

        String[] nullArr = null;

        MaxPrefix prefixFinder = new MaxPrefix();

        String prefix1 = prefixFinder.findMaxLengthPrefix(arr);
        assert prefix1.equals("test");

        String emptyStr = prefixFinder.findMaxLengthPrefix(empty);
        assert emptyStr.equals("");

        String maxLengthPrefix = prefixFinder.findMaxLengthPrefix(nullArr);
        assert maxLengthPrefix.equals("");
    }

    public String findMaxLengthPrefix(String[] arr) {

        if (arr == null || arr.length == 0) return "";

        int minLength = Math.min(arr[0].length(), arr[1].length());

        for (int i = 1; i < arr.length - 1; i++) {
            int nextMin = Math.min(arr[i].length(), arr[i + 1].length());
            if (minLength > nextMin) {
                minLength = nextMin;
            }
        }

        char[] resChars = new char[minLength];

        for (int i = 0; i < minLength; i++) {

            for (int j = 0; j < arr.length - 1; j++) {

                char candidate = arr[j].charAt(i);
                if (candidate == arr[j + 1].charAt(i)) {
                    resChars[i] = candidate;
                }
            }
        }
        return resChars[0] == (int) '0' ? "" : new String(resChars).intern();
    }
}
