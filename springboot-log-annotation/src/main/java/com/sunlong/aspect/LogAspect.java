package com.sunlong.aspect;


import com.sunlong.annotation.Mylog;
import com.sunlong.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
     */
    @Pointcut("execution(public * com.sunlong.service.impl..*.*(..))")
    public void serviceLogAspect() {
    }

    /**
     * 通知
     * @param
     */
/*    @Before(value="@annotation(com.sunlong.annotation.Mylog)")
    public void dofore(JoinPoint jp) {
        try {
            //通过获取Mylog注解
            Method proxyMethod = ((MethodSignature) jp.getSignature()).getMethod();
            Method targetMethod = jp.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
            Mylog Mylog = targetMethod.getAnnotation(Mylog.class);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            //处理注解逻辑
            String age = Mylog.moduleName();
            String tip = "";

            request.setAttribute("tip", tip);
        } catch (Throwable e) {
            System.out.println("有异常啊");
        }
    }*/

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