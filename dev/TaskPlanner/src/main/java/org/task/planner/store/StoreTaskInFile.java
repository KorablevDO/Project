package org.task.planner.store;

import org.task.planner.task.Task;

import java.io.*;

public class StoreTaskInFile implements Store {
    private String patch;

    public StoreTaskInFile(String patch) {
        this.patch = patch;
    }

    public boolean saveTask(Task task) {
        File file = new File(this.patch);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            FileWriter writer = new FileWriter(file, true);
            writer.write(task.toString() + "\r\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }
}
