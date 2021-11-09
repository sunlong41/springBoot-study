package com.sunlong.service.impl;

import com.sunlong.service.Consumer;
import com.sunlong.service.TestServer;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class ConsumerImpl implements Consumer {

    //拿到服务提供方的接口
    @Reference
    TestServer service;
    @Override
    public String consumer() {
        String s = service.test();
        System.out.println(s);
        return s;
    }
}
