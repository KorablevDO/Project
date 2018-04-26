package ProjectServer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class RunServer {
    private static final Logger log = LogManager.getLogger(RunServer.class);

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

    }

    private static void action() throws IOException, ClassNotFoundException {
        ServerUDP server = new ServerUDP();
        server.run();
    }

    private static void end(){

    }
}
