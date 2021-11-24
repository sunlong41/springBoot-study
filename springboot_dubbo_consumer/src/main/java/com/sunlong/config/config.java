package com.sunlong.config;

import com.sunlong.service.Consumer;
import com.sunlong.service.impl.ConsumerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class config {
    @Bean
    public Consumer get() {
        System.out.println("从配置文件里面获取ConsumerImpl");
        return new ConsumerImpl();
    }
}
