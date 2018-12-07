package org.ru.dev.service;

public class Service {
    private static String directory = "dev/src/main/resources/";
    private static int i;

    public static void main(String[] args) {
        init();
        action();

        while (true){
            if (true){
                break;
            }
        }

        end();

    }

    private static void init(){
        System.out.println("Init");
        i = 0;
    }

    private static void action(){
        while (true){
            i++;
            System.out.println(i);
        }
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