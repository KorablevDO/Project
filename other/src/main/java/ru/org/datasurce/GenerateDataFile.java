package ru.org.datasurce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.org.tasks.TasksDataStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateDataFile {
    private static final Logger LOGGER = LogManager.getLogger(GenerateDataFile.class);
    private static GenerateDataFile generateDataFile;

    private GenerateDataFile(){

    }

    public static GenerateDataFile get(){
        if(generateDataFile == null){
            generateDataFile = new GenerateDataFile();
        }

        return generateDataFile;
    }

    public void generateDataFile(String path, int size) throws IOException {
        File file = new File(path);

        if(!file.exists()){
            file.createNewFile();
        }

        int wordSize = 16;
        List<String> pullLines = StringDataSource.get().getListString(size, wordSize);
        Stream<String> stream = pullLines.stream().map(s -> s = s + " ");
        List<String> lines = stream.collect(Collectors.toList());
        FileOutputStream outputStream = new FileOutputStream(file);

        for(String line : lines){
            outputStream.write(line.getBytes());
        }
    }
}
