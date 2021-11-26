package com.sunlong.aspect;


import com.sunlong.annotation.Mylog;
import com.sunlong.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
@Aspect
public class LogAspect {

    @Autowired
    private LogService LogService;

    /**
     * 切入点
     * com.sunlong.service.impl
     * execution表达式
     * execution表示需要嵌入的包类和方法，精度是到方法。其中表示通配。
     * 例: * com.trusfort…sdk.controller..(…)
     * !execution表示需要排除的方法，表达式之间用&&或 || 符号连接，需要注意此处逻辑关系。
     * 例：* com.trusfort…sdk.controller.AuthTokenController.genToken2(…)
     */
    @Pointcut("execution(public * com.sunlong.service.impl..*.*(..))")
    public void serviceLogAspect() {
    }

    /**
     * 通知
     * @param
     */
    @Before("execution(public * com.sunlong.service.impl.*(..))")
    public void before(){
        System.out.println("执行方法前======");
    }
    @After("execution(public * com.sunlong.service.impl.*(..))")
    public void after(){
        System.out.println("执行方法后=====");
    }
    @Around("execution(public * com.sunlong.service.impl.*(..))")
    public void round(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("环绕前");
        System.out.println(joinPoint.getSignature());
        Object proceed = joinPoint.proceed();
        System.out.println("环绕后");
        System.out.println(proceed);
    }

    /**
     * 前置通知在业务代码执行之前执行，后置通知在业务代码之后执行，异常通知在业务代码发生异常时执行，最终通知在最后执行
     * @param pj
     * @param annotation
     * @return
     */
    @Around(value = "serviceLogAspect() && @annotation(annotation) &&args(..) ", argNames = "pj,annotation")
    public String interceptorApplogic(ProceedingJoinPoint pj, Mylog annotation){

        LogService.printConsoleLog(pj,annotation);  //输出日志到控制台
        String result = null;
        try {
            result = pj.proceed().toString();
            if (result !=null && result.length()>0){
            }else{
            }
        }catch (Throwable e){
        }
        return result;

    }

}