package org.task.planner.task;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by do.korablev on 07.02.2019.
 */
public class TaskBuffer {
    private List<Task> taskList;

    public TaskBuffer(){
        this.taskList = new CopyOnWriteArrayList<>();
    }

    public TaskBuffer(List<Task> taskList){
        if(taskList != null) {
            this.taskList = Collections.synchronizedList(taskList);
        } else {
            this.taskList = new CopyOnWriteArrayList<>();
        }
    }

    public void addTask(Task task){
        synchronized (this) {
            this.taskList.add(task);
        }
    }

    public Task get(int index){
        synchronized (this){
            return this.taskList.get(index);
        }
    }

    public int lenght(){
        synchronized (this){
            return this.taskList.size();
        }
    }
}
