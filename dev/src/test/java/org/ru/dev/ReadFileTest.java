package org.ru.dev;

import org.ru.dev.service.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class ReadFileTest {

    public void readFileInteger() throws IOException {
        String path = "dev/src/main/resources/dataPull0.txt";
        File file = new File(path);
        ReadFile<Integer> reader = new ReadFile<Integer>();
        Deque<Integer> deque = new ArrayDeque<>();
        reader.setDeque(deque);
        reader.read(file);
        System.out.println(deque.toString());
    }

    public void readFileString() throws IOException {
        String path = "dev/src/main/resources/dataPull0.txt";
        File file = new File(path);
        ReadFile<String> reader = new ReadFile<String>();
        Deque<String> deque = new ArrayDeque<>();
        reader.setDeque(deque);
        reader.read(file);
        System.out.println(deque.toString());
    }
}
