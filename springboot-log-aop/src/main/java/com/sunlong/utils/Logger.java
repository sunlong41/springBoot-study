package com.sunlong.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 用来记录日志的类(模拟的通知类)
 */
@Component("txAdvice")
@Aspect//表示当前类是一个切面类
public class Logger {

    /**
     * 切入点表达式
     * 第一个*代表方法返回值
     * 接着是包名
     * 第二个*代表包下面所有类
     * 第三个*代表类里面所有方法
     * （..）代表方法里面所有参数
     */
    @Pointcut("execution(* com.sunlong.service.*.*(..))")
    private void pt1(){};

    /**
     * 前置通知
     */
    @Before("execution(* com.sunlong.service.*.*(..))")
    public void beforeAdvice(){
        System.out.println("before:开始记录日志...");
    }
    /**
     * 后置通知
     */
    @AfterReturning("execution(* com.sunlong.service.*.*(..))")
    public void afterAdvice(){
        System.out.println("afterAdvice......");
    }
    /**
     * 最终通知
     */
    @After("pt1()")//注意:不要忘记写括号
    public void finallyAdvice(){
        System.out.println("finallyAdvice.........");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("pt1()")
    public void exceptionAdvice(){
        System.out.println("exceptionAdvice....");
    }


    /**
     * 环绕通知
     * @param pjp
     */

    @Around("pt1()")
    public Object aroundPringLog(ProceedingJoinPoint pjp){
        Object obj = null;
        try {
            Object[] args = pjp.getArgs();// 得到方法所需的参数
            System.out.println("环绕通知:前置...");
            //明确调用业务层方法
            obj = pjp.proceed(args);
            System.out.println("环绕通知:后置...");
            return obj;
        } catch (Throwable throwable) {
            System.out.println("环绕通知:异常...");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("环绕通知:最终...");
        }
    }
}

