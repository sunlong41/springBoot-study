package com.sunlong.control;

import com.sunlong.annotation.Mylog;
import com.sunlong.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test/{name}")
    @Mylog(moduleName = "模块X",option = "更新")
    public String  dosth(@PathVariable("name") String name){
      return testService.dosth(name);
    }
}
