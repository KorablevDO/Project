package ProjectClient;

import java.io.IOException;

public class RunClientTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ClientUDP client = new ClientUDP();
        client.run("456");
    }
}
