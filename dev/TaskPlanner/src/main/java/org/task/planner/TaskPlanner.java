package org.task.planner;

import org.task.planner.notifications.OutputTasksInPanel;
import org.task.planner.provider.ProviderTasksOfFile;
import org.task.planner.service.ServiceTaskPlanner;
import org.task.planner.task.Task;
import org.task.planner.userinterface.UserInterfaceGUI;

import java.util.List;

public class TaskPlanner {
    private static String path1 = "Test.txt";
    private static String path2 = "Test.txt";
    private static List<Task> list;

    public static void main(String[] args) {
        init();
        action();
        end();
    }

    private static void init(){
        System.out.println("Init");
        ProviderTasksOfFile providerTasksOfFile = new ProviderTasksOfFile(path1);
        list = providerTasksOfFile.importListTasks();
    }

    private static void action(){
        System.out.println("Action");
        /**
         * TODO Проработка вопроса с интерфейсом. Хочу сделать веб интерфейс но пока что не понимаю что мне нужно.
         * https://o7planning.org/ru/10129/spring-mvc-tutorial-for-beginners
         */


        Thread thread1 = new Thread(new UserInterfaceGUI());
        thread1.start();

        OutputTasksInPanel outputTasksInPanel = new OutputTasksInPanel();
        outputTasksInPanel.setTaskList(list);
        Thread thread2 = new Thread(outputTasksInPanel);
        thread2.start();

        Thread thread3 = new Thread(new ServiceTaskPlanner(path2));
        thread3.start();
        while (true){

        }

    }

    private static void end(){
        System.out.println("End");
    }
}
