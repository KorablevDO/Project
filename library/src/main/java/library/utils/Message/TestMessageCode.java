package library.utils.Message;

import library.utils.Object.Message;
import library.utils.Session.UDPSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;

public class TestMessageCode {
    private static final Logger log = LogManager.getLogger(TestMessageCode.class);
    public static void init(UDPSession udpSession){
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
                udpSession.receive(datagramPacket);
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
    }
}
