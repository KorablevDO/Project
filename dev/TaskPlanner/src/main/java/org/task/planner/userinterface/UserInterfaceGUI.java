package org.task.planner.userinterface;

import org.task.planner.service.ServiceTaskPlanner;
import org.task.planner.userinterface.form.UserInterfaceForm;

import javax.swing.*;

/**
 * Created by 1 on 04.02.2019.
 */
public class UserInterfaceGUI implements Runnable {
    private ServiceTaskPlanner taskPlanner;

    @Override
    public void run() {
        UserInterfaceForm gui = new UserInterfaceForm();
        JFrame frame = new JFrame("UserInterface");
        frame.setContentPane(gui.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public void setTaskPlanner(ServiceTaskPlanner taskPlanner) {
        this.taskPlanner = taskPlanner;
    }
}