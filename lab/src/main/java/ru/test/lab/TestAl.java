package ru.test.lab;

import com.sun.javafx.collections.MappingChange;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by do.korablev on 20.05.2019.
 */
public class TestAl {
    private static int value = 764;

    public static void main(String[] args) {
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(500, 5);
        map.put(100, 5);
        map.put(50, 5);
        map.put(10, 5);
        go(map);
    }

    private static void go(Map<Integer, Integer> map) {
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            int size = (int) entry.getValue();
            int number = (int) entry.getKey();

            while (true) {
                if (size > 0) {
                    int e = i + number;
                    if (e < value) {
                        i = e;
                        size--;
                    } else if (e == value) {
                        i = e;
                        if (i == value) {
                            System.out.println("true: " + i);
                        } else {
                            System.err.println("false: " + i);
                        }
                        return;
                    } else if (e > value) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }

        if (i == value) {
            System.out.println("true: " + i);
        } else {
            System.err.println("false: " + i);
        }
    }

    private static int call() {


        return 0;
    }

}
