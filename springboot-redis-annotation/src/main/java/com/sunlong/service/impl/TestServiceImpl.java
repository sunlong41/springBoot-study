package com.sunlong.service.impl;

import com.sunlong.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String doSomeThing() {
        return "我们做了复杂的业务";
    }
}
