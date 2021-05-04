package com.dan.task1;

import com.dan.runner.Runner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1 implements Runner {

    private final Path path;
    private final int lineCount;
    private int randomBound = 2020;

    public Task1(String path, int lineCount) {
        this.path = Paths.get(path);
        this.lineCount = lineCount;
    }

    public Task1(String path, int lineCount, int randomBound) {
        this.path = Paths.get(path);
        this.lineCount = lineCount;
        this.randomBound = randomBound;
    }

    public Path getPath() {
        return path;
    }


    public void fillRandoms() throws IOException {
        Random random = new Random();
        List<Integer> collect = IntStream.generate(() -> random.nextInt(randomBound)).limit(lineCount).boxed().collect(Collectors.toList());

        int first = 423;
        int second = 1597;

        generateValues(random, collect, first, second);

        path.toFile().createNewFile();
        Files.readAllLines(path).forEach(System.out::println);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            collect.forEach(integer -> {
                try {
                    bufferedWriter.write(integer + "\n");
                } catch (IOException e) {
                    throw new RuntimeException("Cannot write units.");
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Exception on accessing to task file.");
        }
    }

    private void generateValues(Random random, List<Integer> collect, int first, int second) {
        collect.set(random.nextInt(lineCount), first);
        collect.set(random.nextInt(lineCount), second);
    }

    @Override
    public void runner() throws Exception {
        final int SUM = 2020;

        try (BufferedReader reader = Files.newBufferedReader(path)) {
            List<Integer> inputInts = reader.lines().map(Integer::parseInt).collect(Collectors.toList());

            for (int i = 0; i < inputInts.size() - 1; i++) {
                for (int j = i + 1; j < inputInts.size(); j++) {
                    if (inputInts.get(i) + inputInts.get(j) == SUM) {
                        System.out.println("Sum result is: " + inputInts.get(i) + " " + inputInts.get(j));
                    }
                }
            }
        }
    }

    /**
     * Uses as default runner by filling initial data and resources.
     * A default source to the read/write operations is src/main/resources/${task#.txt}.
     * If the file is not exist it will be automatically created by the fillRandoms() method.
     * @throws IOException, if cannot to open or write the file.
     */
    public static void defaultRunner() throws IOException {
        Task1 task1 = new Task1("src/main/resources/task1.txt", 200);
        if (!task1.getPath().toFile().exists()) {
            task1.fillRandoms();
        }
        final int SUM = 2020;

        try (BufferedReader reader = Files.newBufferedReader(task1.getPath())) {
            List<Integer> inputInts = reader.lines().map(Integer::parseInt).collect(Collectors.toList());

            for (int i = 0; i < inputInts.size() - 1; i++) {
                for (int j = i + 1; j < inputInts.size(); j++) {
                    if (inputInts.get(i) + inputInts.get(j) == SUM) {
                        System.out.println("Sum result is: " + inputInts.get(i) + " " + inputInts.get(j));
                    }
                }
            }
        }
    }
}
