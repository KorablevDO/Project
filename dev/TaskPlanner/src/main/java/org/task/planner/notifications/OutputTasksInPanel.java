package org.task.planner.notifications;

import org.task.planner.task.Task;
import org.task.planner.userinterface.form.UserInterfaceForm;

import javax.swing.*;
import java.util.List;

/**
 * Created by 1 on 04.02.2019.
 */
public class OutputTasksInPanel implements Runnable {
    private List<Task> taskList;

    @Override
    public void run() {
        Notifications gui = new Notifications();
        JFrame frame = new JFrame("UserInterface");
        frame.setContentPane(gui.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JLabel label = gui.getText();
        label.setText(taskList.toString());
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }
}
