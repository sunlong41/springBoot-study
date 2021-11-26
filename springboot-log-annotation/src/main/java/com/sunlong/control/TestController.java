package com.sunlong.control;

import com.sunlong.annotation.Mylog;
import com.sunlong.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test/{name}")
    //@Mylog(moduleName = "模块X",option = "更新") (配置在这里不生效，是否生效跟切点配置有关)
    public String  dosth(@PathVariable("name") String name){
      return testService.dosth(name);
    }

    /**
     * 1、连接点（JoinPoint）
     * 连接点是在应用执行过程中能够插入切面（Aspect）的一个点。这些点可以是调用方法时、甚至修改一个字段时。它是一个虚拟的概念，例如坐地铁的时候，每一个站都可以下车，那么这每一个站都是一个接入点。假如一个对象中有多个方法，那么这个每一个方法就是一个连接点。
     * 2、切入点（Pointcut）
     * 切入点是一些特使的连接点，是具体附加通知的地方。例如坐地铁的时候，具体在某个站下车，那这个站就是切入点
     * 3、切面 （Aspect）
     * 切面是通知和切入点的结合，通知规定了在什么时机干什么事，切入点规定了在什么地方。如“在8点钟在西站下车“ 就是一个切面。那么时间8点，动作下车就是一个通知。西站就是一个切入点。
     * 4、引入（introduction）
     *  允许我们向现有的类添加新方法属性。
     * 5、织入（weaving）
     * 把切面应用到目标对象并创建代理对象的过程。切点在指定的连接点(切点)被织入到目标对象中。在目标的生命周期中，有多个点可以被织入：
     * 编译期、类加载期、运行期
     * 6、通知(Advice)
     * 通知定义了何时，做什么。

     */
}
