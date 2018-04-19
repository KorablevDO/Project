package ProjectServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * https://habrahabr.ru/post/330676/
 * https://habrahabr.ru/post/209144/
 * http://javatutor.net/books/tiej/socket
 * https://tproger.ru/
 */
public class Server {
    public void run() throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(3345);
        Socket clientSocket = serverSocket.accept();

        System.out.print("Connection accepted.");

        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        System.out.println("DataOutputStream  created");

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        System.out.println("DataInputStream created");

        while (!clientSocket.isClosed()){
            System.out.println("Server reading from channel");

            String entry = in.readUTF();
            System.out.println("READ from client message - "+entry);
            System.out.println("Server try writing to channel");

            if(entry.equalsIgnoreCase("quit")){
                System.out.println("Client initialize connections suicide ...");
                out.writeUTF("Server reply - "+entry + " - OK");
                out.flush();
                Thread.sleep(3000);
//                break;
            }

            out.writeUTF("Server reply - "+entry + " - OK");
            System.out.println("Server Wrote message to client.");

            out.flush();
        }

        System.out.println("Client disconnected");
        System.out.println("Closing connections & channels.");

        in.close();
        out.close();

        clientSocket.close();
    }
}
