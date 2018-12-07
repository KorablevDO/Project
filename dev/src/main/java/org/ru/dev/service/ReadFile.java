package org.ru.dev.service;

import java.io.*;
import java.util.List;

public class ReadFile<T> {
    private List<T> list;
    private char separator = ',';

    public void setList(List<T> list){
        this.list = list;
    }

    public void read(File file) throws IOException {
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        int data;
        StringBuffer buffer = new StringBuffer();
        while ((data = reader.read()) != 0){
            char c = (char) data;
            buffer.append(c);

            if(c == this.separator){
                this.list.add((T) buffer.toString());
            }
        }
    }
}
