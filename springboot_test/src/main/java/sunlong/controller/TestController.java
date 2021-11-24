package sunlong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.spring.boot.JsonSerial;
import spring.boot.spring.boot.entity.Entity;
import sunlong.entity.Person;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private JsonSerial js;
    @Autowired
    private Entity vo;

    @RequestMapping("/hello")
    public String index() {
        return js.serial(new Person("22", "22"));
    }

    @RequestMapping("/test")
    public String indexx() {
        return js.serial(vo);
    }
}
