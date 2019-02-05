package org.task.planner.provider;

import org.task.planner.task.Task;
import org.task.planner.task.TaskBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProviderTasksOfFile implements Provider {
    private String path;

    public ProviderTasksOfFile(String path) {
        this.path = path;
    }

    public List<Task> importTasks() {
        List<Task> listTasks = new ArrayList<Task>();
        File file = new File(this.path);
        if (file.exists()) {
            List<String> list = new ArrayList<>();
            FileInputStream stream = null;
            try {
                stream = new FileInputStream(file);
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                String line;
                while ((line = reader.readLine()) != null){
                    list.add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            }
            System.out.println("Size : " + list.size());

            for(String line : list){
                if(!line.equals("")) {
                    String[] arr = line.split("; ");
                    Task task = new TaskBuilder()
                            .setIdTask(Integer.valueOf(arr[0].split(":")[1].replace(" ", "")))
                            .setName(arr[1])
                            .setDescription(arr[2])
                            .build();
                    listTasks.add(task);
                }
            }

            return listTasks;
        }

        return null;
    }
}
