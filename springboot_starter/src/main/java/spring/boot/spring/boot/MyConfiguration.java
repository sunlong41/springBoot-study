package spring.boot.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.boot.spring.boot.entity.Entity;
import spring.boot.spring.boot.entity.EntityProperties;

import javax.annotation.Resource;

@Configuration   //标注为配置类 源码中可以看到 标注这个注解的类会被加载
@ConditionalOnClass(Entity.class)    // 该注解意思是 有“”Entity“”类才起作用 通俗来说就是你不注该服务类，就不会去注入下面的类,条件注解
@EnableConfigurationProperties(EntityProperties.class)   //开启配置文件
public class MyConfiguration {

    @Autowired
    private EntityProperties properties; //注入配置文件

    @Bean
    @ConditionalOnMissingBean()     //该注解的意思是如果没有发现service的bean就执行新建一个bean
    public Entity entity() {
        return new Entity(properties.getA(), properties.getB(),properties.getC());
    }
}
