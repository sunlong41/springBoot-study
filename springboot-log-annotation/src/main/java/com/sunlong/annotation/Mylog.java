package com.sunlong.annotation;


import java.lang.annotation.*;

/**
 * 系统日志自定义注解
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
    public @interface Mylog {

    //模块名
    String moduleName() default "";

    //操作内容
    String option() default "";


}
