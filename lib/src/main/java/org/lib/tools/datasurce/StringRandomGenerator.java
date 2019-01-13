package org.lib.tools.datasurce;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * StringRandomGenerator
 * Отвечает за генерацию случайной строки символов
 */
public class StringRandomGenerator {
    private static final Random random = new Random();
    private static final int defaultSize = 5;
    private static final int defaultListSize = 20;

    public static List<String> getListString() {
        return getListString(defaultListSize, defaultSize);
    }
    
    public static List<String> getListString(int listSize) {
        return getListString(listSize, defaultSize);
    }

    public static List<String> getListString(int listSize, int size) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(getRandomLatinString(random.nextInt(size)+1));
        }
        return list;
    }

    public static String getRandomLatinString(int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            str = str + getRandomLatinSymbol();
        }
        return str;
    }

    private static String getRandomLatinSymbol() {
        char rc = (char) ('A' + new Random().nextInt(26));
        return String.valueOf(rc);
    }
}
