package org.ru.dev.service;

public class Service {
    private static int i;

    public static void main(String[] args) {
        init();
        action();
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
 *  Технологии;
 *  Java SE 8
 *  Паттерны программирования
 *  TestNG
 *  SpringFramework
 *  JMX
 *  jasper reports
 *  Gradle
 *
 */