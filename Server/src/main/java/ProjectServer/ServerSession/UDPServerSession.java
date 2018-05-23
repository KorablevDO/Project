package ProjectServer.ServerSession;

import ProjectServer.RunServer;
import library.utils.Message.MessageSettings;
import library.utils.Message.ReadMessageBuffer;
import library.utils.Object.Message;
import library.utils.Session.UDPSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.SocketException;

public class UDPServerSession extends AddServerSession {
    private static final Logger log = LogManager.getLogger(RunServer.class);
    private UDPSession udpSession;
    private int port = this.serverSettings.getPort();

    //TODO реализовать буффер сообщений
    //TODO через спринг реализовать подключение модуля сообщение где идет реализация сообщения

    public UDPServerSession(ServerSettings serverSettings) {
        super(serverSettings);
    }

    public void getMessages() {
        if(this.udpSession != null){
            log.info("Init reads message");
            MessageSettings settings = new MessageSettings();
            byte[] messageBuffer = new byte[settings.getLenght()];
            DatagramPacket datagramPacket = new DatagramPacket(messageBuffer, messageBuffer.length);
            Message message = null;
            ByteArrayInputStream inputStream = null;
            ObjectInputStream in = null;
            byte[] data = null;
            ReadMessageBuffer buffer = ReadMessageBuffer.get();
            try {
                while (true) {
                    this.udpSession.receive(datagramPacket);
                    data = datagramPacket.getData();
                    inputStream = new ByteArrayInputStream(data);
                    in = new ObjectInputStream(inputStream);
                    message = (Message) in.readObject();
                    buffer.setMessage(message);
                }
            } catch (IOException e) {
                log.error(e.toString());
            } catch (ClassNotFoundException e) {
                log.error(e.toString());
            } finally {
                try {
                    inputStream.close();
                    in.close();
                } catch (IOException e) {
                    log.error(e.toString());
                }
            }
            //TODO создать поток в котором идет чтение сообщений
        }
    }

    public void setMessages() {
        if(this.udpSession != null){
            //TODO создать поток в котором идет отправка сообщения
        }
    }

    public void openSession() {
        log.info("Open session, port: " + this.port);
        try {
            this.udpSession = UDPSession.get(this.port);
        } catch (SocketException e) {
            log.error(e.toString());
        }
    }

    public void close() {
        this.udpSession.close();
    }
}
