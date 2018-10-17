package ru.org.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TasksDataStreams {
    private static final Logger LOGGER = LogManager.getLogger(TasksDataStreams.class);

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

    public List<String> runFor(List<String> list){
        list.sort(String.CASE_INSENSITIVE_ORDER);
        LOGGER.debug(list);
        List<String> result = new ArrayList<>();

        for(int i = list.size() - 1; i > -1; i--){
            result.add(list.get(i));
            if(result.size() == 500){
                break;
            }
        }

        return result;
    }

    public List<String> runStream(List<String> list){
        int max = 10;
        Stream<String> stream = list.parallelStream();
        return stream.sorted().filter(str -> str.length() == max).limit(500).collect(Collectors.toList());
    }

    public List<String> distinct(List<String> list){
        Stream<String> stream = list.stream();
        return stream.distinct().collect(Collectors.toList());
    }

    public void protocol(List<String> list){
        int max = 10;
        Stream<String> stream = list.stream().filter(str -> str.length() == max);
    }


}
