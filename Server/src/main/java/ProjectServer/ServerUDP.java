package ProjectServer;

import library.utils.Object.Message;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerUDP {
    public void run() throws IOException, ClassNotFoundException {
        DatagramSocket serverSocket = new DatagramSocket(3310);
        //создаем пакет
        byte[] messageBuffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(messageBuffer, messageBuffer.length);


        System.out.println("Ожидаем данные...");

        while (true){
            //получаем данные
            serverSocket.receive(packet);
            byte[] data = packet.getData();
            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            Message message = (Message) in.readObject();
            inputStream.close();
            in.close();

            System.out.println(message.message);

            //отправляем данные
//            DatagramPacket outMessage = new DatagramPacket(message.message.getBytes(),
//                    message.message.length(),
//                    packet.getAddress(),
//                    packet.getPort());
//            serverSocket.send(outMessage);

            if(message.message.equals("end")){
                break;
            }
        }
    }
}
/**
 * UDP - выстрелили и забыл.
 * Как может быть реализована работа ?
 * Организовать поток в котором сруца сообщения и потом я выдергиваю из коллекции сообщения,
 * обрабатываю и выплеввываю сообщение обратно.
 */