package org.task.planner.userinterface.form;

import javax.swing.*;

/**
 * Created by 1 on 04.02.2019.
 */
public class UserInterfaceForm {
    private JPanel rootPanel;
    private JButton addTaskButton;
    private JTextField textFieldName;
    private JTextField textFieldText;

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
}
