package ProjectServer.ServerSession;

import library.utils.Message.MessageSettings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerSettings {
    //@Value("${port}")
    private int port = 3310;
    private MessageSettings  messageSettings = new MessageSettings();

    public int getPort(){
        return this.port;
    }

    public MessageSettings getMessageSettings(){
        return this.messageSettings;
    }
}
