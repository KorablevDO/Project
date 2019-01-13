package org.lib.tools.datasurce;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class StringRandomGeneratorTest {

    @Test
    public void testGetListString() throws Exception {
        int listSize = 10;
        int size = 10;
        List<String> list = StringRandomGenerator.getListString(listSize, size);
        System.out.println(list);
    }

    @Test
    public void testGetRandomLatinString() throws Exception {
        int listSize = 5;
        String line = StringRandomGenerator.getRandomLatinString(listSize);
        System.out.println(line);
    }
}