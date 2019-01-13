package org.lib.tools.datasurce;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by 1 on 13.01.2019.
 */
public class FileRandomDataGeneratorTest {

    @Test
    public void testCreateDataFile() throws Exception {
        String path = "Data.txt";
        int size = 10;
        FileRandomDataGenerator.createDataFile(path, size);
    }

}