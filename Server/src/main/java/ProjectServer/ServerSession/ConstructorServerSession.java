package ProjectServer.ServerSession;

import library.utils.Message.MessageSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorServerSession {
    private ServerSession serverSession;
    private int port;
    private MessageSettings messageSettings;

    @Autowired
    public ConstructorServerSession(ServerSession serverSession){
        this.serverSession = serverSession;
    }

    public void setSettings(ServerSettings settings){
        this.port = settings.getPort();
        this.messageSettings = settings.getMessageSettings();
    }

    public void openSession(){
        this.serverSession.openSession(this.port);
    }

    public void readMessages(){
        this.serverSession.readMessages();
    }

    public void dispatchMessages(){
        this.serverSession.dispatchMessages();
    }

    public void close(){
        this.serverSession.close();
    }
}
