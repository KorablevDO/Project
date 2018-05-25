package ProjectServer;

import ProjectServer.ServerSession.ServerSession;
import ProjectServer.ServerSession.ServerSettings;
import ProjectServer.ServerSession.UDPServerSession;
import library.instruments.Spring.SpringAnnotation.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

public class RunServer {
    private static final Logger log = LogManager.getLogger(RunServer.class);
    private static ServerSession serverSession;

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        outInfoMessage();
        init();
        action();
        end();
    }

    private static void outInfoMessage(){
        log.info("Init run server");
    }

    private static void init(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationServer.class);
        serverSession = context.getBean(ServerSession.class);
        serverSession.setServerSettings(new ServerSettings());
        //TODO переделать под спринг
        //TODO Переделать получение серверных настроек через спринг
        serverSession.openSession();
    }

    private static void action() throws IOException, ClassNotFoundException {
        serverSession.readMessages();
        serverSession.dispatchMessages();

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void end(){
        serverSession.close();
    }
}
