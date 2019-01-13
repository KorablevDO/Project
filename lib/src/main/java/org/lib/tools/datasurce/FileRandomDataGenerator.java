package org.lib.tools.datasurce;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRandomDataGenerator {

    public static void createDataFile(String path, int size) throws IOException {
        File file = new File(path);

        if(!file.exists()){
            file.createNewFile();
        }

        int wordSize = 16;
        List<String> pullLines = StringRandomGenerator.getListString(size, wordSize);
        Stream<String> stream = pullLines.stream().map(s -> s = s + " ");
        List<String> lines = stream.collect(Collectors.toList());
        FileOutputStream outputStream = new FileOutputStream(file);

        for(String line : lines){
            outputStream.write(line.getBytes());
        }
    }
}
