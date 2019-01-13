package ru.test.lab.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class TasksDataStreams {

    public IntStream getIntStream(int[] array) {
        return Arrays.stream(array);
    }

    public List<String> runFor(List<String> list) {
        list.sort(String.CASE_INSENSITIVE_ORDER);
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
        System.out.println("Start parallelStream " + System.currentTimeMillis());
        Stream<String> parallel = list.parallelStream().filter(s -> s.length() > sizeBigWord);
        System.out.println("Stop parallelStream " + System.currentTimeMillis());
    }

    public void streamFilter(List<String> list, int sizeBigWord) {
        System.out.println("Start stream " + System.currentTimeMillis());
        Stream<String> stream = list.stream().filter(s -> s.length() > sizeBigWord);
        System.out.println("Stop stream " + System.currentTimeMillis());
    }

    public Stream<Long> getLongStream(long a, int c, long t) {
        return Stream.iterate(a, p -> p = (a * p + c) % t);
    }

    public Stream<String> getSymbolicallyStringStream(String line) {
        return IntStream.range(0, line.length()).mapToObj(i -> line.substring(i, i + 1));
    }

    public Boolean wordLineTest(String line){
        return line.codePoints().allMatch(i -> Character.isAlphabetic(i));
    }

    public Boolean checkStringIdentifier(String line){
        int symbol = (int)'_';
        boolean result1 = line.codePoints().skip(1).allMatch(i -> Character.isAlphabetic(i) || Character.isDigit(i));
        boolean result2 = line.codePoints().limit(1).allMatch(i -> Character.isUpperCase(i) || i == symbol);
        boolean result3 = line.codePoints().anyMatch(i -> Character.isWhitespace(i));
        return result1  && result2 && !result3;
    }

    public List<String> getWordsOfFileWithElements(String file, String split, int size) throws IOException {
        Stream<String> stream = getStream(file);
        Stream<String> streamElements = split(stream, split);
        Stream<String> result = streamElements.filter(s -> wordLineTest(s));
        return result.limit(size).collect(Collectors.toList());
    }

    private Stream<String> getStream(String file) throws IOException {
        Path path = Paths.get(file);
        return Files.lines(path);
    }

    private Stream<String> split(Stream<String> stream, String split){
        return stream.flatMap(s -> Arrays.asList(s.split(split)).stream());
    }

    public List<String> getFrequentlyUsedWordsFromFileWithElements(String file, String split, int size) throws IOException {
        Stream<String> stream = getStream(file);
        Stream<String> streamElements = split(stream, split);

        return streamElements.sorted().collect(Collectors.toList());
    }
}
