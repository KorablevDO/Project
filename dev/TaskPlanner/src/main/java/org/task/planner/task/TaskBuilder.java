package org.task.planner.task;

import java.io.PrintWriter;

/**
 * Created by 1 on 01.02.2019.
 */
public class TaskBuilder {
    private int idTask;
    private String name;
    private String description;


    public TaskBuilder setIdTask(int idTask) {
        this.idTask = idTask;
        return this;
    }

    public TaskBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TaskBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Task build(){
        Task task = new Task();
        task.setId(this.idTask);
        task.setName(this.name);
        task.setDescription(this.description);
        return task;
    }
}
