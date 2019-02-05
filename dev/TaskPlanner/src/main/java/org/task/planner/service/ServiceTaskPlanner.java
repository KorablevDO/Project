package org.task.planner.service;

import org.task.planner.store.StoreTaskInFile;
import org.task.planner.task.Task;
import org.task.planner.task.TaskBuilder;
import org.task.planner.userinterface.UserInterfaceWebService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class ServiceTaskPlanner implements Runnable {
    private String path;

    public ServiceTaskPlanner(String path){
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("Run ServiceTaskPlanner");
        int id = 1;
        String name = "Test";
        String newTask = "Задача по добавлению задачи";
        Task task = new TaskBuilder()
                .setIdTask(id)
                .setName(name)
                .setDescription(newTask)
                .build();
        System.out.println(task);
        StoreTaskInFile store = new StoreTaskInFile(this.path);
        store.saveTask(task);

//        try {
//            URL url = new URL("http://localhost:8080/wss/hello?wsdl");
//            QName qName = new QName("http://userinterface.planner.task.org/", "UserInterfaceWebServiceImplService");
//            Service service = Service.create(url, qName);
//            UserInterfaceWebService webService = service.getPort(UserInterfaceWebService.class);
//            System.out.println(webService.getHello(" LoL "));
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }
}
