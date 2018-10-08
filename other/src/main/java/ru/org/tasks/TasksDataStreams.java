package ru.org.tasks;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TasksDataStreams {
    public List<Integer> getList(int size){
        List<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for(int i = 0; i < size; i++){
            list.add( random.nextInt(size));
        }
        return list;
    }

    private Random random = new Random();


    public List<String> getDataString(int size){
        List<String> list = new ArrayList<>();
        int max = 10;
        for(int i = 0; i < size; i++){
            String str = convert(getRandomStr(this.random.nextInt(max) + 1));
            list.add(str);
        }
        return list;
    }

    private String getRandomStr(int size){
        int ascMax = 79;
        int ascMin = 41;
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < size; i++){
            String convert = Character.toString((char)(this.random.nextInt(ascMax) + ascMin));
            buffer.append(convert);
        }
        return buffer.toString();
    }

    private String convert(String str){
        return new String(str.getBytes(), StandardCharsets.UTF_8);
    }
}
