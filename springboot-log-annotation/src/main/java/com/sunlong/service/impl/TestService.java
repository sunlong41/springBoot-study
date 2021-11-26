package com.sunlong.service.impl;

import com.sunlong.annotation.Mylog;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Mylog(moduleName = "模块X",option = "更新")
    public String dosth(String name) {

        int result= 0;
        if (result>0){
            return "success";
        }
        return  "failed";
    }

    @Mylog(moduleName = "模块X",option = "更新")
    public  String test1(){
        return "1";
    }
}
