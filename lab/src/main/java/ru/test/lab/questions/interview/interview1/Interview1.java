package ru.test.lab.questions.interview.interview1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Interview1 {
    public int getNumberWords(String line){
        char[] arr = line.toCharArray();
        StringBuffer buffer = new StringBuffer();
        List<String> list = new ArrayList<>();
        for(char c : arr){
            if(Character.isLetter(c)){
                buffer.append(c);
            } else {
                list.add(buffer.toString());
                buffer.setLength(0);
            }
        }

        list.add(buffer.toString());
        buffer.setLength(0);

        return list.size();
    }

    public int[] removeDuplicates(int[] arr){
        IntStream stream = Arrays.stream(arr).distinct();
        return stream.toArray();
    }
}
