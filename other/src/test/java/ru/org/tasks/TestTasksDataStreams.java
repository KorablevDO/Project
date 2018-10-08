package ru.org.tasks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTasksDataStreams {
    private static final Logger logger = LogManager.getLogger(TestTasksDataStreams.class);
    private static final TasksDataStreams streams = new TasksDataStreams();

    /**
     * В методы filter и map можно передать лямда выражения и методы
     */
    @Test
    public void testConverToStream(){
        List<Integer> list = streams.getList(100);
        Stream<Integer> stream = list.stream();
        List<Integer> result = stream.collect(Collectors.toList());
    }

    @Test
    public void testStreamFilter(){
        List<Integer> list = streams.getList(100);
        /**
         * Метод filter позволяет создать новый поток с определенными данными
         */
        Stream<Integer> stream = list.stream().filter(integer -> integer.intValue() > 10 && integer.intValue() < 20);
        List<Integer> result = stream.collect(Collectors.toList());
    }

    @Test
    public void testStreamMap(){
        List<Integer> list = streams.getList(100);
        /**
         * Метод map позволяет модернизировать данные в потоке
         */
        Stream<Integer> stream = list.stream().map(integer -> integer.intValue() + 10);
        List<Integer> result = stream.collect(Collectors.toList());
    }

}

/*
1. Наладить работу с тест нг как это надо мне
2. Подключить логерр
https://devcolibri.com/тестирование-с-помощью-testng-в-java/
 */