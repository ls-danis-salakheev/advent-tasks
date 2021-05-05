package com.dan.task4;

import com.dan.runner.Runner;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 implements Runner {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/task4.txt");
        String s = Files.readString(path);
//        System.out.println(s);

//        BufferedReader bufferedReader = Files.newBufferedReader(path);
//        bufferedReader.lines()
//                .map(s1 -> s1.split(" "))
//                .forEach(arr-> System.out.println(Arrays.toString(arr)));

        Scanner scanner = new Scanner(path);
//
        List<String> strings = readWords(scanner);
        System.out.println(strings);
//        List<String> strings = new ArrayList<>();
//        while (scanner.hasNext()) {
//            strings.add(scanner.next());
//        }

//        BufferedReader bufferedReader = Files.newBufferedReader(path);
//        bufferedReader.readLine();
//        var collect = bufferedReader.lines().collect(Collectors.toList());
//
//        var datas = new ArrayList<>();
//        for (String str:collect) {
//            if(!str.isEmpty()) {
//                var data = new ArrData(str);
//                datas.add(data);
//            }
//        }
//
//        System.out.println(collect);
//        System.out.println(datas.size());
//        List<String[]> resString = strings.stream().map(string -> string.split(" ")).collect(Collectors.toList());


//        resString.forEach(arr -> System.out.println(Arrays.toString(arr)));

//        parseOneLine(resString);


    }

    private static List<String> readWords(Scanner source) {
        String word = null;
        List<String> words = new ArrayList<>();
        while (!(word = source.nextLine()).isEmpty()) {
            words.add(word);
        }
        return words;
    }

    private static void parseOneLine(List<String[]> resString) {
        Password password = new Password();
        for (int i = 0; i < resString.size(); i++) {
            if (resString.get(i)[0].equals("ecl")) {
                password.setEcl(resString.get(i)[1]);
            }
            if (resString.get(i)[0].equals("pid")) {
                password.setPid(Integer.parseInt(resString.get(i)[1]));
            }
            if (resString.get(i)[0].equals("eyr")) {
                password.setEyr(Integer.parseInt(resString.get(i)[1]));
            }
            if (resString.get(i)[0].equals("hcl")) {
                password.setHcl(resString.get(i)[1]);
            }
            if (resString.get(i)[0].equals("byr")) {
                password.setByr(Integer.parseInt(resString.get(i)[1]));
            }
            if (resString.get(i)[0].equals("iyr")) {
                password.setIyr(Integer.parseInt(resString.get(i)[1]));
            }
            if (resString.get(i)[0].equals("cid")) {
                password.setCid(Integer.parseInt(resString.get(i)[1]));
            }
            if (resString.get(i)[0].equals("hgt")) {
                password.setHgt(resString.get(i)[1]);
            }
        }

        System.out.println(password);
    }


    @Override
    public void runner() {

    }
}


class ArrData {
    private String data;

    public ArrData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ArrData{" +
                "data='" + data + '\'' +
                '}';
    }
}
