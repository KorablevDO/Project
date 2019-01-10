package library.utils.Session;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPSession {
    private static UDPSession udpSession;
    private DatagramSocket datagramSocket;

    private UDPSession(){}

    public static UDPSession get(int port) throws SocketException {
        if(udpSession == null){
            udpSession = new UDPSession();
            udpSession.createSession(port);
        }
        return udpSession;
    }

    private void createSession(int port) throws SocketException {
        this.datagramSocket = new DatagramSocket(port);
    }

    public void send(DatagramPacket datagramPacket) throws IOException {
        this.datagramSocket.send(datagramPacket);
    }

    public DatagramPacket receive(DatagramPacket datagramPacket) throws IOException {
        this.datagramSocket.receive(datagramPacket);
        return datagramPacket;
    }

    public void close(){
        if(this.datagramSocket != null) {
            this.datagramSocket.close();
        }
    }
}
