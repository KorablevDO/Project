package ProjectServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class CreateUDPSession {
    private CreateUDPSession createUDPSession;
    private DatagramSocket datagramSocket;

    private CreateUDPSession(){}

    public CreateUDPSession get(int port) throws SocketException {
        if(this.createUDPSession == null){
            this.createUDPSession = new CreateUDPSession();
            this.datagramSocket = new DatagramSocket(port);
        }

        return this.createUDPSession;
    }

    public void send(DatagramPacket datagramPacket) throws IOException {
        this.datagramSocket.send(datagramPacket);
    }

    public DatagramPacket receive(DatagramPacket datagramPacket) throws IOException {
        this.datagramSocket.receive(datagramPacket);
        return datagramPacket;
    }
}
