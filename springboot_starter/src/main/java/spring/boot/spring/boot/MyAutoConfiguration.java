package spring.boot.spring.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAutoConfiguration {

    @Bean
    public JsonSerial jsonSerial(){
        return new JsonSerial();
    }
}
