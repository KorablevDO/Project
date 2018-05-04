package test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

    @Bean
    public EventLogger logger(){
        return new ConsoleEventLogger();
    }

    @Bean
    public ObjectMessage message(){
        ObjectMessage o = new ObjectMessage();
        o.id = "2";
        o.fullName = "test";
        return o;
    }
}
