package ru.test.lab.questions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestQuestions {

    @Test
    private void objectAsKey(){
        String value = "Hello World";
        String result = ObjectAsKey.init(value);
        Assert.assertTrue(value.equals(result));
    }
}
