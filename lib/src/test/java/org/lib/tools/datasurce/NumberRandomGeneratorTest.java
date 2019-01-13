package org.lib.tools.datasurce;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by 1 on 13.01.2019.
 */
public class NumberRandomGeneratorTest {

    @Test
    public void testGetIntArrayNumbers() throws Exception {
        int lenght = 10;
        int min = 0;
        int max = 10000;
        int[] arr = NumberRandomGenerator.getIntArrayNumbers(lenght, min, max);
        for(int i : arr) {
            System.out.println(i);
        }
    }

}