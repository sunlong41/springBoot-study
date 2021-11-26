package com.sunlong.main;

import com.sunlong.config.SpringConfiguration;
import com.sunlong.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    //测试
    public static void main(String[] args) {
        // 加载配置类,获取创建Spring容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //得到AccountService对象
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        //执行方法
        accountService.saveAccount();
        /**
         * 在使用除环绕通知的其他通知时，他们的顺序并不是一定的，最终通知会执行优先于后置通知与环绕通知,
         * 因此当我们使用最终通知来释放一些资源的时候，可能会出现资源已经释放，但是后置通知仍在使用的情况，
         * 这时就会出现错误，因此我们遇到这种情况时要特别注意，为了保证通知的顺序，我们必要的使用环绕通知，环绕通知的执行顺序是一致的。
         */
    }
}
