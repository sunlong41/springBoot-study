package com.sunlong.service.impl;

import com.sunlong.annotation.Mylog;
import com.sunlong.entity.Person;
import com.sunlong.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LogServiceImpl implements LogService {

    @Override
    public void printConsoleLog(ProceedingJoinPoint pj, Mylog annotation) {
        System.out.println("sssssss");
        try {
            //获取当前执行用户
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            Person Person = (Person) request.getSession().getAttribute("sunlong");

            //获取当前执行操作的用户对象
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            //获取方法名

            Method method=((MethodSignature)pj.getSignature()).getMethod();
            System.out.println("方法名："+method.getName());
            //获取系统时间
            String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
            for(Object obj : pj.getArgs()){
                System.out.println("参数:"+obj.toString());
            }
        }

    }
}
