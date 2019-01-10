package ProjectClient;

import library.utils.Object.Message;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class ClientUDP {
    public void run(String line) throws IOException, InterruptedException {
        DatagramSocket clientSocket = new DatagramSocket();
        Message message = new Message();
        Random random = new Random();
        while (true){
            message.message = String.valueOf(random.nextInt(1000)) + line;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            out.writeObject(message);
            byte[] data = outputStream.toByteArray();
            out.close();

            //отправляем сообзение
            String adderss = "localhost";
            DatagramPacket packet = new DatagramPacket(data,
                    data.length,
                    InetAddress.getByName(adderss),
                    3310);
            clientSocket.send(packet);
            System.out.println("отправил");
//            Thread.sleep(1000);
        }
    }
}

//http://snakeproject.ru/rubric/article.php?art=java_10