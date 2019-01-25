package ProjectServer;

import ProjectServer.ServerSession.ConstructorServerSession;
import ProjectServer.ServerSession.ServerSettings;
import library.utils.ImportSettings.ImportSettings;
import library.utils.ImportSettings.ImportSettingsFromNewObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@ComponentScan
public class RunServer {
    private static final Logger log = LogManager.getLogger(RunServer.class);
    private static ConstructorServerSession constructorServerSession;

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
        ImportSettings importSettings = new ImportSettingsFromNewObject();
        ServerSettings settings = null;
        try {
            settings = (ServerSettings) importSettings.getObjectSettings(ServerSettings.class);
        } catch (Exception e) {
            log.error(e.toString());
        }
        ApplicationContext context = new AnnotationConfigApplicationContext(RunServer.class);
        constructorServerSession = context.getBean(ConstructorServerSession.class);
        constructorServerSession.setSettings(settings);
        constructorServerSession.openSession();
    }

    private static void action() throws IOException, ClassNotFoundException {

        constructorServerSession.readMessages();
        constructorServerSession.dispatchMessages();

        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            log.error(e.toString());
        }
    }

    private static void end(){
        constructorServerSession.close();
    }
}
