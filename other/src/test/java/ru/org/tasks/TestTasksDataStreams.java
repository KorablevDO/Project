package ru.org.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import ru.org.datasurce.StringDataSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTasksDataStreams {
    private static final Logger LOGGER = LogManager.getLogger(TestTasksDataStreams.class);
    private static final TasksDataStreams DATA_STREAMS = new TasksDataStreams();

    /**
     * В методы filter и map можно передать лямда выражения и методы
     */
    @Test
    public void testConverToStream(){
        List<Integer> list = DATA_STREAMS.getList(100);
        Stream<Integer> stream = list.stream();
        List<Integer> result = stream.collect(Collectors.toList());
    }

    @Test
    public void testStreamFilter(){
        List<Integer> list = DATA_STREAMS.getList(100);
        /**
         * Метод filter позволяет создать новый поток с определенными данными
         */
        Stream<Integer> stream = list.stream().filter(integer -> integer.intValue() > 10 && integer.intValue() < 20);
        List<Integer> result = stream.collect(Collectors.toList());
    }

    @Test
    public void testStreamMap(){
        List<Integer> list = DATA_STREAMS.getList(100);
        /**
         * Метод map позволяет модернизировать данные в потоке
         */
        Stream<Integer> stream = list.stream().map(integer -> integer.intValue() + 10);
        List<Integer> result = stream.collect(Collectors.toList());
    }
    //****************************************************************************************************

    /**
     * 1
     */
    @Test
    public void protocol(){
        int i = 10;
        List<String> list = DATA_STREAMS.getDataString(10);
        LOGGER.info(list.toString());
        DATA_STREAMS.protocol(list);
    }

    /**
     * 2
     */
    public void comparison(){
        int i = 188088;
        List<String> list = DATA_STREAMS.getDataString(10);
        LOGGER.info(list.toString());

    }

    @Test
    public void test1(){
        List<String> list = DATA_STREAMS.getDataString(10);
        LOGGER.info(list.toString());
    }

    /**
     * 4
     */
    @Test
    public void t4(){
        int listSize = 10;
        int wordSize = 10;
        List<String> list = StringDataSource.get().getListString(listSize, wordSize);
        LOGGER.info(list.toString());
    }

    /**
     * 5
     */
    @Test
    public void t5(){

    }

    /**
     * 6
     */
    @Test
    public void t6(){

    }

    /**
     * 7
     */
    @Test
    public void t7(){

    }

    /**
     * 8
     */
    @Test
    public void t8(){

    }

    /**
     * 9
     */
    @Test
    public void t9(){

    }

    /**
     * 10
     */
    @Test
    public void t10(){

    }

    /**
     * 11
     */
    @Test
    public void t11(){

    }

    /**
     * 12
     */
    @Test
    public void t12(){

    }

    /**
     * 13
     */
    @Test
    public void t13(){

    }

    /**
     * 14
     */
    @Test
    public void t14(){

    }

    /**
     * 15
     */
    @Test
    public void t15(){

    }

    /**
     * 16
     */
    @Test
    public void measuringTime(){
        int i = 188088;
        List<String> list = DATA_STREAMS.getDataString(i);
        LOGGER.info("Size = " + list.size());

        List<String> test = Arrays.asList("adffhfdh","fgsfhrtrtdgfg", "fhcfddt","sgfh","dfgsfhtrebcvdfhdfhs");

        LOGGER.info("Star For");
        List<String> runFor = DATA_STREAMS.runFor(list);
        LOGGER.info("Stop For");
        LOGGER.info("Size result = " + runFor.size());
        LOGGER.info(runFor);

        LOGGER.info("Star Stream");
        List<String> runStream = DATA_STREAMS.runStream(list);
        LOGGER.info("Stop Stream");
        LOGGER.info("Size result = " + runStream.size());
        LOGGER.info(runStream);
    }

    /**
     * 17
     */
    @Test
    public void distinct(){
        List<String> list = Arrays.asList("aaa","aaa","aaa","ddd","ddd","qq","qq","qq","qq");
        LOGGER.info(list);
        List<String> distinct = DATA_STREAMS.distinct(list);
        LOGGER.info(distinct);

        /**
         *  для удаления дубликатов использовал метод distinct
         */
    }

}

/*
1. Наладить работу с тест нг как это надо мне
2. Подключить логерр
https://devcolibri.com/тестирование-с-помощью-testng-в-java/
 */