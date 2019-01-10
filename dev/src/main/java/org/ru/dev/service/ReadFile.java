package org.ru.dev.service;

import java.io.*;

public class ReadFile {
    private char separator = ',';

    public void read(File file) throws IOException {
        System.out.println(file.getName());
        InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
        int data;
        StringBuffer buffer = new StringBuffer();
        MathematicalOperation operation = new MathematicalOperation();

        while ((data = reader.read()) != 0){
            char c = (char) data;

            if(c != this.separator){
                buffer.append(c);
            } else {
                String result = buffer.toString();
                long l = operation.operationMultiplications(Integer.valueOf(result));
//                System.out.println("File = " + file.getName() + " : old = " + result + " : new = " + l);
                buffer.setLength(0);
            }
        }
    }
}
