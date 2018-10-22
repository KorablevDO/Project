package ru.org.patterns.singleton;

/**
 * Класс реализован по принцепу паттерна singleton - одиночка ограничиват класс наличием только одного экземпляром в
 * программе и обеспечивает даступ к нему.
 */

public class T1 {
    private static T1 instance;

    private T1(){

    }

    public static T1 getInstance(){
        if(instance == null){
            /**
             * Если данный класс принимает участие в много поточном программировании то необходимо реализовать механизм
             * синхронизации.
             */
            instance = new T1();
        }

        return instance;
    }
}
