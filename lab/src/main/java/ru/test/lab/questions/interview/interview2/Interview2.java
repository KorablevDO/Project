package ru.test.lab.questions.interview.interview2;

import java.util.*;

public class Interview2 {
    private final int notLess = 1;
    private Map<String, List<String>> map;
    private String line;

    public Interview2(String line) {
        this.line = line;
    }


    public List<String> getGroup(char a) {
        if (this.map != null) {
            return this.map.get(String.valueOf(a));
        } else {
            Set<Character> charSet = getKeyCharSet(this.line);
            groupedMap(line, charSet);
            return this.map.get(String.valueOf(a));
        }
    }

    private Set<Character> getKeyCharSet(String line) {
        String[] arr = line.split(" ");
        Set<Character> charSet = new HashSet(arr.length);
        for (String str : arr) {
            char[] chars = str.toCharArray();
            char a = chars[0];
            charSet.add(a);
        }

        return charSet;
    }

    private void groupedMap(String line, Set<Character> charSet) {
        String[] arr = line.split(" ");
        for (char a : charSet) {
            List<String> list = getGroupedList(a, arr);

            Comparator<String> comparator = new SizeComparator().thenComparing(new SortComparator());
            list.sort(comparator);

            if (list.size() > this.notLess) {
                if (this.map == null) {
                    this.map = new TreeMap<>();
                }

                this.map.put(String.valueOf(a), list);
            }
        }
    }

    private List<String> getGroupedList(char a, String[] arr) {
        List<String> list = new ArrayList<>();
        for (String str : arr) {
            char[] chars = str.toCharArray();
            char b = chars[0];
            if (b == a) {
                list.add(str);
            }
        }
        return list;
    }

    public Map<String, List<String>> getMap() {
        return this.map;
    }
}
