package com.dan.task5;

import java.util.List;

public class Task5 {

    public static void main(String[] args) {
        List<String> SEATS = List.of("BFFFBBFRRR", "FFFBBBFRRR", "BBFFBBFRLL");

        char[] chars = SEATS.get(0).toCharArray();

        Period seat = new Period();
        if (chars[0] == 'F') { // 0 --- 127
            seat.maxRow /= 2;
        } else seat.minRow = seat.maxRow / 2;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == 'F') {
//                int in = (seat.maxRow - seat.minRow) / 2;
                seat.maxRow -= (seat.maxRow - seat.minRow) / 2;
            }
            if (chars[i] == 'B') {
//                int in = (seat.maxRow - seat.minRow) / 2;
                seat.minRow += (seat.maxRow - seat.minRow) / 2;
            }
        }

        System.out.println(seat);

    }

    static class Period {
        int minRow = 0;
        int maxRow = 126;
        int minSeat = 0;
        int maxSeat = 7;

        public Period() {
        }

        @Override
        public String toString() {
            return "Period{" +
                    "minRow=" + minRow +
                    ", maxRow=" + maxRow +
                    '}';
        }
    }
}
