package ProjectServer.ServerSession;

import library.utils.Message.TestMessageCode;
import library.utils.Session.UDPSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.SocketException;

@Component
public class UDPServerSession implements ServerSession {
    private static final Logger log = LogManager.getLogger(UDPServerSession.class);
    private UDPSession udpSession;
    private int port;

    //TODO реализовать буффер сообщений
    //TODO через спринг реализовать подключение модуля сообщение где идет реализация сообщения
    public UDPServerSession(){
    }

    @Autowired
    public UDPServerSession(ServerSettings serverSettings){
        this.port = serverSettings.getPort();
    }

    public void setServerSettings(ServerSettings serverSettings) {
        this.port = serverSettings.getPort();
    }

    public void readMessages() {
        log.info("Open stream read message.");
        if (this.udpSession != null) {
            log.info("Reads message.");
            TestMessageCode.init(this.udpSession);
            //TODO создать поток в котором идет чтение сообщений
        } else {
            log.error("Not reads message: Not found session.");
        }
    }

    public void dispatchMessages() {
        log.info("Open stream read message.");
        if (this.udpSession != null) {
            //TODO создать поток в котором идет отправка сообщения
        } else {
            log.error("Not dispatchs message: Not found session.");
        }
    }

    public void openSession() {
        log.info("Open session");
        try {
            this.udpSession = UDPSession.get(this.port);
            log.info("Open session, port: " + this.port);
        } catch (SocketException e) {
            log.error(e.toString());
        } catch (NullPointerException e) {
            log.error("No port found, check settings.");
        }
    }

    public void close() {
        this.udpSession.close();
    }
}
