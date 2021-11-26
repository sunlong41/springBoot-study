package com.sunlong.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.sunlong")
@EnableAspectJAutoProxy //开启AOP代理自动配置
public class SpringConfiguration {
}
