package ru.test.lab.questions;

import java.util.HashMap;
import java.util.Map;

/**
 * Вопрос: Как использовать объект в качестве ключа в Map
 * Статус: Требуется дополнительные изыскания.
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

}
