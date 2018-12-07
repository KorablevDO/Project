package org.ru.dev;

import org.ru.dev.service.ReadFile;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadFileTest {

    public void readFileInteger() throws IOException {
        String path = "dev/src/main/resources/dataPull0.txt";
        File file = new File(path);
        ReadFile<Integer> reader = new ReadFile<Integer>();
        List<Integer> list = new LinkedList<Integer>();
        reader.setList(list);
        reader.read(file);
        System.out.println(list.toString());
    }

    public void readFileString() throws IOException {
        String path = "dev/src/main/resources/dataPull0.txt";
        File file = new File(path);
        ReadFile<String> reader = new ReadFile<String>();
        List<String> list = new LinkedList<String>();
        reader.setList(list);
        reader.read(file);
        System.out.println(list.toString());
    }
}
