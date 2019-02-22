package ru.test.lab.questions.interview.interview2;

import java.util.Comparator;

public class SortComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
