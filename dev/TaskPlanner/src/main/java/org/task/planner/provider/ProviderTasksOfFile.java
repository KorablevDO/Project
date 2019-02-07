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

    public List<Task> importListTasks(){
        File file = new File(this.path);

        if(!file.exists()){
            return null;
        }

        List<String> list = null;
        try {
            list = readFileInListString(file);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        if((list != null) && (list.size() > 0)) {
            List<Task> taskList = parseLineToTask(list);
            if(taskList.size() > 0){
                return taskList;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private List<String> readFileInListString(File file) throws IOException {
        List<String> list = new ArrayList<>();
        FileInputStream stream = new FileInputStream(file);
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line;
        while ((line = reader.readLine()) != null){
            list.add(line);
        }
        return list;
    }

    private List<Task> parseLineToTask(List<String> list){
        List<Task> listTasks = new ArrayList<Task>();
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
}
