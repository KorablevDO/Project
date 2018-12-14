package org.ru.dev.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateFiles {
    private static Random random = new Random();
    private static String path = "dev/src/main/resources/";
    private static int size = 100;
    private static int lineSize = 100;
    private static int number = 1;

    public static void main(String[] args) throws IOException {
        for(int i = 0; i < number; i++){
            generateFiles(path + "dataPull" + i + ".txt");
        }
    }

    private static void generateFiles(String path) throws IOException {
        File file = new File(path);

        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream outputStream = new FileOutputStream(file);
        List<String> list = generateDataPull(size, lineSize);
        for(String line : list) {
            outputStream.write(line.getBytes());
        }

        outputStream.close();
    }

    private static List<String> generateDataPull(int size, int lineSize){
        List<String> list = new ArrayList<String>(size);

        for(int i = 0; i < size; i++){
            list.add(generateLine(lineSize));
        }

        return list;
    }

    private static String generateLine(int lineSize){
        StringBuffer buffer = new StringBuffer();

        for(int i = 0; i < lineSize; i++){
            String line = String.valueOf(random.nextInt(10000) + 1000);
            buffer.append(line);

            if(i + 1 < lineSize){
                buffer.append(",");
            }
        }

        return buffer.toString();
    }
}
