package org.ru.dev.service;

import java.io.*;
import java.util.Deque;

public class ReadFile<T> {
    private boolean limit = false;
    private Deque<T> deque;
    private char separator = ',';

    public void setDeque(Deque<T> deque){
        this.deque = deque;
    }

    public void read(File file) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        int data;
        StringBuffer buffer = new StringBuffer();

        while ((data = reader.read()) != 0){
            char c = (char) data;

            if(c != this.separator){
                buffer.append(c);
            } else {
                this.deque.add((T) buffer.toString());
                buffer.setLength(0);
            }
        }
    }
}
