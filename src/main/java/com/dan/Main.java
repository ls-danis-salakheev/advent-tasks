package com.dan;

import com.dan.runner.Runner;
import com.dan.task5.Task5;

public class Main {

    public static void main(String[] args) throws Exception {
        Runner task5 = new Task5("src/main/resources/task5.txt");
        task5.runner();
    }
}

