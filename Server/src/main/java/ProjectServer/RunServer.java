package ProjectServer;

import ProjectServer.ServerSession.ServerSession;
import ProjectServer.ServerSession.ServerSettings;
import ProjectServer.ServerSession.UDPServerSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        serverSession = new UDPServerSession(new ServerSettings());
        //TODO переделать под спринг
        //TODO Переделать получение серверных настроек через спринг
        serverSession.openSession();
    }

    private static void action() throws IOException, ClassNotFoundException {
        serverSession.getMessages();
        serverSession.setMessages();

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
