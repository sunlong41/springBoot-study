package com.sunlong.service;

import com.sunlong.annotation.Mylog;
import org.aspectj.lang.ProceedingJoinPoint;

public interface LogService {
    void printConsoleLog(ProceedingJoinPoint pj, Mylog annotation);
}
