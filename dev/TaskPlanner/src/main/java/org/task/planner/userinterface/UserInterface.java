package org.task.planner.userinterface;

import javax.xml.ws.Endpoint;

@Deprecated
public class UserInterface implements Runnable {
    @Override
    public void run() {
        System.out.println("Run User Interface");
        Endpoint.publish("http://localhost:8080/wss/hello", new UserInterfaceWebServiceImpl());
    }
}
