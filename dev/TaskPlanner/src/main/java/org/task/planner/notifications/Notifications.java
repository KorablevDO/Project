package org.task.planner.notifications;

import javax.swing.*;
import java.awt.event.ComponentAdapter;

/**
 * Created by 1 on 04.02.2019.
 */
public class Notifications {
    private JPanel rootPanel;
    private JLabel text;

    public Notifications() {
        rootPanel.addComponentListener(new ComponentAdapter() {
        });
    }

    public JPanel getRootPanel(){
        return this.rootPanel;
    }
}
