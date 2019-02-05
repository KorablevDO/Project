package org.task.planner.notifications;

import org.task.planner.userinterface.form.UserInterfaceForm;

import javax.swing.*;

/**
 * Created by 1 on 04.02.2019.
 */
public class TestNot implements Runnable {
    @Override
    public void run() {
        Notifications gui = new Notifications();
        JFrame frame = new JFrame("UserInterface");
        frame.setContentPane(gui.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
