package org.ru.dev.service;

import java.io.*;

/**
 * Класс отвечает за выгрузку данных из файла
 */
public class FileUploader {
    private char separator = ',';
    private File file;
    private InputStreamReader stream;
    private StringBuffer buffer;

    public FileUploader(File file){
        this.file = file;
    }

    public void openFile() throws FileNotFoundException {
        this.stream = new InputStreamReader(new FileInputStream(this.file));
        this.buffer = new StringBuffer();
    }

    public void close() throws IOException {
        this.stream.close();
    }

    public int next() throws IOException {
        int data;
        String result = "";
        while ((data = this.stream.read()) != 0){
            char c = (char) data;

            if(c != this.separator){
                this.buffer.append(c);
            } else {
                 result = buffer.toString();
                this.buffer.setLength(0);
            }
        }
        return Integer.valueOf(result);
    }
}
