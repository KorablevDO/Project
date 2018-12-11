package org.ru.dev.service;

import java.io.*;
import java.util.Deque;

public class ReadFile {
    private boolean limit = false;
    private char separator = ',';

    public void read(File file) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        int data;
        StringBuffer buffer = new StringBuffer();

        while ((data = reader.read()) != 0){
            char c = (char) data;

            if(c != this.separator){
                buffer.append(c);
            } else {

                buffer.setLength(0);
            }
        }
    }
}
