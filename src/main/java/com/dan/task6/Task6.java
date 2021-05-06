package com.dan.task6;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Task6 {

    public static void main(String[] args) throws IOException {

        String path = "src/main/resources/task6.txt";
//        List<String> collect = Files
//                .lines(Path.of(path))
//                .collect(Collectors.toList());

//        collect.stream().map(s-> s.split("[\\r\\n]+")).forEach(System.out::println);
        String s = Files
                .readString(Path.of(path));

        String[] split = s.split("\r\n");
        System.out.println(Arrays.toString(split));


//        var groups = new ArrayList<>();
//        for (int i = 0; i < collect.size(); i++) {
//
//            if(!collect.get(i).equals("")) {
//                Group group = new Group(collect.get(i));
//                groups.add(group);
//            }
//            else {
//                var aGroup = new Group("");
//                while (Objects.equals(collect.get(i), "")) {
//                    aGroup.add(collect.get(i));
//                    i++;
//                }
//            }
//        }
//
//        System.out.println(groups);
    }


    static class Group {

        private String people;

        public Group(String people) {
            this.people = people;
        }

        public void add(String str) {
            StringBuilder stringBuilder = new StringBuilder(people);
            stringBuilder.append(str);
        }

        @Override
        public String toString() {
            return "Group{" +
                    "people=" + people +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Group group = (Group) o;

            return Objects.equals(people, group.people);
        }

        @Override
        public int hashCode() {
            return people != null ? people.hashCode() : 0;
        }
    }
}
