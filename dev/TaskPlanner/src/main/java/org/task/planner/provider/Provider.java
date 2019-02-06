package org.task.planner.provider;

import org.task.planner.task.Task;

import java.util.List;

public interface Provider {
    public List<Task> importListTasks();
}
