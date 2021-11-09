package com.sunlong.service.impl;

import com.sunlong.service.TestServer;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service
@Component //使用dubbo的时候不要用service
public class TestServerImpl implements TestServer {

    @Override
    public String test() {
        return "helloworld";
    }
}
