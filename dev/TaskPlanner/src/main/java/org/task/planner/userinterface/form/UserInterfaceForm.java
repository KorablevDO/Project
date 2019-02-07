package org.task.planner.userinterface.form;

import org.task.planner.service.ServiceTaskPlanner;
import org.task.planner.task.Task;
import org.task.planner.task.TaskBuffer;
import org.task.planner.task.TaskBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by 1 on 04.02.2019.
 */
public class UserInterfaceForm {
    private JPanel rootPanel;
    private JButton addTaskButton;
    private JTextField textFieldName;
    private JTextField textFieldText;
    private TaskBuffer buffer;

    public UserInterfaceForm() {
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textFieldName.getText();
                String text = textFieldText.getText();
                Task task = new TaskBuilder()
                        .setIdTask(1)
                        .setName(name)
                        .setDescription(text)
                        .build();
                buffer.addTask(task);
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }

    public JButton getAddTaskButton() {
        return addTaskButton;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldText() {
        return textFieldText;
    }

    public void setBuffer(TaskBuffer buffer) {
        this.buffer = buffer;
    }
}
