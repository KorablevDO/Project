package ProjectClient;

import java.io.IOException;

public class RunClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        client.run();
    }
}
