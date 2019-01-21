package org.ru.dev.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Класс отвечает за поставку данных в сервис
 */
public class Provider {
    private FileUploader file;

    public void search(String path) throws FileNotFoundException {
        File file = new File(path);

        if(!file.exists()){
            throw new SecurityException("File not found");
        }

        FileUploader fileUploader = new FileUploader(file);
        fileUploader.openFile();
        this.file = fileUploader;
    }



    /**
     * Метод возвращает следующее число
     * @return
     */
    public String next(){
        try {
            return file.next();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
