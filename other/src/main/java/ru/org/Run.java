package ru.org;

import ru.org.questions.ObjectAsKey;

public class Run {
    public static void main(String[] args) {
        String value = "Hello World";
        String result = ObjectAsKey.init(value);
        if(value.equals(result)){
            System.out.println(result);
        } else {
            System.out.println("error");
        }
    }
}
