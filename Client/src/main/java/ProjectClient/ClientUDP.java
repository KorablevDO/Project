package ProjectClient;

import library.utils.Object.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientUDP {
    public void run() throws IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        Message message = new Message();
        message.message = "end";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        out.writeObject(message);
        byte[] data = outputStream.toByteArray();
        out.close();

        while (true){
            //отправляем сообзение
            String adderss = "localhost";
            DatagramPacket packet = new DatagramPacket(data,
                    data.length,
                    InetAddress.getByName(adderss),
                    3310);
            clientSocket.send(packet);
            System.out.println("отправил");
            break;
        }
    }
}

//http://snakeproject.ru/rubric/article.php?art=java_10