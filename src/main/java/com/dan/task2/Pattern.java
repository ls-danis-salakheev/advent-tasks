package com.dan.task2;

public class Pattern {
    private final int min;
    private final int max;
    private final String aChar;
    private final String password;

    public Pattern(int min, int max, String aChar, String password) {
        this.min = min;
        this.max = max;
        this.aChar = aChar;
        this.password = password;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public String getaChar() {
        return aChar;
    }

    public boolean isValid() {
        int count = 0;
        char[] chars = password.toCharArray();
        for (char c : chars) {
            if (c == aChar.charAt(0)) {
                count++;
            }
        }
        return min <= count && count <= max;
    }

    @Override
    public String toString() {
        return "Pattern{" + min + "-"
                + max + " " + aChar + ": " + password + "}";

    }
}


