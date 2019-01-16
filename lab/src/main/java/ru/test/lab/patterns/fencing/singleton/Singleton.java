package ru.test.lab.patterns.fencing.singleton;

/**
 * Класс реализован по принцепу паттерна singleton - одиночка ограничиват класс наличием только одного экземпляром в
 * программе и обеспечивает даступ к нему.
 */

public final class Singleton {
    private static Singleton instance;
    private String value;

    private Singleton(){

    }

    private Singleton(String value){
        this.value = value;
    }

    /**
     * Наивный одиночка - просто реализует концепцию паттерна Singleton, решение считается топорным и не подходит для работы
     * в много поточном режиме.
     * @return
     */
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }

        return instance;
    }

    /**
     * Правельный одиночка - одиночка с реализованным механизмом синхранизации для многопоточности.
     * @param value
     * @return
     */
    public static Singleton getInstance(String value) {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton(value);
                }
            }
        }
        return instance;
    }

    public String getValue(){
        return this.value;
    }
}
