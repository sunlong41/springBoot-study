package sunlong.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestComtroller {
    @GetMapping("/test")
    public String test(){
        int a = 1/0;
        System.out.println("success");
        return "sunlong";
    }
}
