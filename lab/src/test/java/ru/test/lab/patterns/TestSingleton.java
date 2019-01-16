package ru.test.lab.patterns;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.test.lab.patterns.fencing.singleton.Singleton;

public class TestSingleton {

    @Test
    public void init(){
        String value = "value";
        Singleton singleton = Singleton.getInstance(value);
        String result = singleton.getValue();

        Singleton singleton1 = Singleton.getInstance();
        String result1 = singleton1.getValue();

        Assert.assertEquals(result, result1);
    }
}
