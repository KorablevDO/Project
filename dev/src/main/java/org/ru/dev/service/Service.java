package org.ru.dev.service;

import java.io.File;

public class Service {
    private static String directory = "dev/src/main/resources/dataPull0.txt";
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
        Provider provider = new Provider();
        provider.search(directory);
        String number;
        while ((number = provider.next()) != null){
            int i = Integer.valueOf(number);
            System.out.println(i*2);
        }
    }

    private static void end(){
        System.out.println("The end");
    }
}
/**
 *  Разработка сервиса: Сервис обработки файлов с набором цифр.
 *  1. Разработать механизм чтения файлов
 *      1.1. Расширить механизм чтения файлов. Реализовать механизм чтения файлов мо мере их поступления в деректорию.
 *  2. Разработать механизм обработки данных.
 *  3. Разработать механизм вывода результата работы приложения.
 *
 *
 * Реализация:
 * 1. Реализовать класс Provider - отвечающий за поставку данных в сервис.
 * 2. Реализовать класс FileUploader - отвечающй за выгрузку данных из файла
 * 3.
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
 * https://proglib.io/p/java-coding-channels/
 */