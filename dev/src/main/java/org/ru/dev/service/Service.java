package org.ru.dev.service;

import java.io.File;
import java.util.*;

public class Service {
    private static String directory = "dev/src/main/resources/";
    private static int i;

    public static void main(String[] args) throws Exception {
        init();
        action();
        end();

    }

    private static void init(){
        System.out.println("Init");
        i = 0;
    }

    private static void action() throws Exception {
        File file = new File(directory);
        File[] files = file.listFiles();
        for(File nextFile : files){
            if(!nextFile.exists()){
                throw new Exception();
            }
        }

        ReadFile<Integer> readFile = new ReadFile<>();
        Deque<Integer> deque = new ArrayDeque<>();
        readFile.setDeque(deque);
        for(File nextFile : files){
            readFile.read(nextFile);
        }

        System.out.println();
    }

    private static void end(){
        System.out.println("The end");
    }
}
/**
 *  Разработка сервиса: Система обрабатывает файлы с цифрами выполня математическое вычисление.
 *  1. Генерация данных.
 *  2. Чтение файла/ов.
 *  3. Выполнение вычисления.
 *  4. Зацикливание операции.
 *  5. Реализация прерывания операции.
 *
 *  Описание:
 *  1. Запускается сервис
 *  2. Инициализируется поток на чтение всех файлов которые приходят в указанную директорию
 *  3. Инициализируется поток который обрабатывает данные которые были вычитаны потоком на чтение
 *
 *  Технологии;
 *  Java SE 8
 *  Паттерны программирования
 *  TestNG
 *  SpringFramework
 *  JMX
 *  jasper reports
 *  Gradle
 *
 *
 *
 * https://habr.com/post/247647/
 *SLF4J  -?
 *
 *
 *
 */