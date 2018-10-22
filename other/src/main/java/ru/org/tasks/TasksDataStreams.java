package ru.org.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.crypto.Data;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TasksDataStreams {
    private static final Logger LOGGER = LogManager.getLogger(TasksDataStreams.class);

    public Stream<Integer> getIntStream(int[] array) {
        IntStream intStream = Arrays.stream(array);
        return  (Stream<Integer>) Arrays.stream(array);
    }

    public List<String> runFor(List<String> list) {
        list.sort(String.CASE_INSENSITIVE_ORDER);
        LOGGER.debug(list);
        List<String> result = new ArrayList<>();

        for (int i = list.size() - 1; i > -1; i--) {
            result.add(list.get(i));
            if (result.size() == 500) {
                break;
            }
        }

        return result;
    }

    public List<String> runStream(List<String> list) {
        int max = 10;
        Stream<String> stream = list.parallelStream();
        return stream.sorted().filter(str -> str.length() == max).limit(500).collect(Collectors.toList());
    }

    public List<String> distinct(List<String> list) {
        Stream<String> stream = list.stream();
        return stream.distinct().collect(Collectors.toList());
    }

    public void getFirstFiveBigWords(List<String> list, int sizeBigWord) {
        list.stream().filter(str -> {
            if (str.length() >= sizeBigWord) {
                System.out.println(str);
                return true;
            } else {
                return false;
            }
        }).limit(5).count();
    }

    public void parallelStreamFilter(List<String> list, int sizeBigWord) {
        LOGGER.info("Start parallelStream " + System.currentTimeMillis());
        Stream<String> parallel = list.parallelStream().filter(s -> s.length() > sizeBigWord);
        LOGGER.info("Stop parallelStream " + System.currentTimeMillis());
    }

    public void streamFilter(List<String> list, int sizeBigWord) {
        LOGGER.info("Start stream " + System.currentTimeMillis());
        Stream<String> stream = list.stream().filter(s -> s.length() > sizeBigWord);
        LOGGER.info("Stop stream " + System.currentTimeMillis());
    }

    public Stream<Long> getLongStream(long a, int c, int t){
        return Stream.iterate(a,null);
    }
}
