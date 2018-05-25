package ProjectServer;

import ProjectServer.ServerSession.ServerSession;
import ProjectServer.ServerSession.UDPServerSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationServer {

    @Bean
    public ServerSession mokServerSession(){
        return new UDPServerSession();
    }
}
