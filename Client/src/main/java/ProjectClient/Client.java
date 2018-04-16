package ProjectClient;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    public void run() throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 3345);//todo что такое сокет и как он работает
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());

        System.out.println("Client connected to socket.");
        System.out.println();
        System.out.println("Client writing channel = oos & reading channel = ois initialized.");

        while (!socket.isOutputShutdown()) {
            System.out.println("Client start writing in channel...");
            Thread.sleep(1000);
            String clientCommand = "quit";

            out.writeUTF(clientCommand);
            out.flush();
            System.out.println("Clien sent message " + clientCommand + " to server.");
            Thread.sleep(1000);

            if (clientCommand.equalsIgnoreCase("quit")) {
                System.out.println("Client kill connections");
                Thread.sleep(2000);

                if (in.read() > -1) {
                    System.out.println("reading...");
                    String message = in.readUTF();
                    System.out.println(message);
                }

                break;
            }

            System.out.println("Client sent message & start waiting for data from server...");
            Thread.sleep(2000);

            if (in.read() > -1) {
                System.out.println("reading...");
                String message = in.readUTF();
                System.out.println(message);
            }

            System.out.println("Closing connections & channels on clentSide - DONE.");
        }
    }
}
