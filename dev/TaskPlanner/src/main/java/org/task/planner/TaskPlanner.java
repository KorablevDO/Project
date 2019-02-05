package org.task.planner;

import org.task.planner.notifications.TestNot;
import org.task.planner.provider.ProviderTasksOfFile;
import org.task.planner.service.ServiceTaskPlanner;
import org.task.planner.task.Task;
import org.task.planner.userinterface.UserInterfaceGUI;

import java.util.List;

public class TaskPlanner {
    private static String path1 = "C:\\Users\\Public\\Desktop\\Test.txt";
    private static String path2 = "C:\\Users\\Public\\Desktop\\Test.txt";

    public static void main(String[] args) {
        init();
        action();
        end();
    }

    private static void init(){
        System.out.println("Init");
        ProviderTasksOfFile providerTasksOfFile = new ProviderTasksOfFile(path1);
        List<Task> list = providerTasksOfFile.importTasks();

        for (Task task1 : list){
            System.out.println(task1);
        }
    }

    private static void action(){
        System.out.println("Action");
        /**
         * TODO Проработка вопроса с интерфейсом. Хочу сделать веб интерфейс но пока что не понимаю что мне нужно.
         * https://o7planning.org/ru/10129/spring-mvc-tutorial-for-beginners
         */
        Thread thread1 = new Thread(new UserInterfaceGUI());
        thread1.start();
        Thread thread2 = new Thread(new TestNot());
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
