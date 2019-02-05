package org.task.planner.store;

import org.task.planner.task.Task;

public interface Store {
    public boolean saveTask(Task task);
}
