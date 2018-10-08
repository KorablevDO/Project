package ru.org.tasks;

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




}
