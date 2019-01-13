package ru.test.lab.patterns;

import org.testng.annotations.Test;
import ru.test.lab.patterns.builder.Director;

public class TestBuilder {

    @Test
    public void build(){
        Director director = new Director()
                .setValue1("test1 ")
                .setValue2("test2 ")
                .setValue3("test3 ");
        String result = director.getResult();
        System.out.println(result);
    }
}
