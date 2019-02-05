package ru.test.lab.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Вопрос: Как использовать объект в качестве ключа в Map
 * Статус: Для корретной работы надо переопределить методы hashCode() и equals(), чтобы код мог правлеьно сранить объекты
 * по ключу.
 */
public class ObjectAsKey {

    public static String init(String value){
        Map map = new HashMap();
        Key key = new Key();
        map.put(key, value);
        return (String)map.get(key);
    }
}

class Key{

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
