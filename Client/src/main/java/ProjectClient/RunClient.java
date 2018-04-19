package ProjectClient;

import java.io.IOException;

/**
 * Created by 1 on 14.02.2018.
 */
public class RunClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Client client = new Client();
        client.run();
    }
}
