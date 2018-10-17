package ru.org.datasurce;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StringDataSource {
    private static final Logger LOGGER = LogManager.getLogger(StringDataSource.class);
    private final Random random = new Random();
    private static StringDataSource stringDataSource;

    private StringDataSource() {

    }

    public static StringDataSource get() {
        if (stringDataSource == null) {
            stringDataSource = new StringDataSource();
        }

        return stringDataSource;
    }

    public List<String> getListString(int listSize, int wordSize) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            list.add(getWord(this.random.nextInt(wordSize)+1));
        }
        return list;
    }

    private String getWord(int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            str = str + getSymbol();
        }
        LOGGER.debug(str);
        return str;
    }

    private String getSymbol() {
        char rc = (char) ('A' + new Random().nextInt(26));
        return String.valueOf(rc);
    }

    public List<String> getLisStringWitchRepeating(){
        return Arrays.asList("qazwsx", "qaz","qaz","qazwsx","qazwsx","edcwsx","edcwsx","edcwsx","rfv");
    }
}
