package com.sunlong.controller;

import com.sunlong.service.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class TestController {

    @Qualifier("get")
    @Autowired
    private Consumer vo;

    @RequestMapping("/hello")
    public String test() {
        return vo.consumer();
    }
}
