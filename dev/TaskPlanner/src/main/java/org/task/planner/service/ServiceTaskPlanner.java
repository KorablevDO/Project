package org.task.planner.service;

import org.task.planner.notifications.form.Notifications;
import org.task.planner.store.StoreTaskInFile;
import org.task.planner.task.Task;
import org.task.planner.task.TaskBuffer;
import org.task.planner.task.TaskBuilder;

import javax.swing.*;
import java.util.List;

public class ServiceTaskPlanner implements Runnable {
    private String path;
    private TaskBuffer buffer;

    public ServiceTaskPlanner(String path){
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("Run ServiceTaskPlanner");

        Notifications gui = new Notifications();
        JFrame frame = new JFrame("UserInterface");
        frame.setContentPane(gui.getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JLabel label = gui.getText();
        int i = 0;
        int lenght = buffer.lenght();
        while (true) {
            Task task = buffer.get(i);
            label.setText(task.toString());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if((i + 1) == lenght){
                i = 0;
                lenght = buffer.lenght();
            } else {
                ++i;
            }
        }


//        int id = 1;
//        String name = "Test";
//        String newTask = "Задача по добавлению задачи";
//        Task task = new TaskBuilder()
//                .setIdTask(id)
//                .setName(name)
//                .setDescription(newTask)
//                .build();
//        System.out.println(task);
//        StoreTaskInFile store = new StoreTaskInFile(this.path);
//        store.saveTask(task);
    }


    public void setBuffer(TaskBuffer buffer) {
        this.buffer = buffer;
    }
}
