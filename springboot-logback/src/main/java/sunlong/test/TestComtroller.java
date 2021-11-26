package sunlong.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestComtroller {
    private static Logger logger = LoggerFactory.getLogger(TestComtroller.class);
    @GetMapping("/test")
    public String test(){
        try {
            int a = 1 / 0;
        }catch (Exception e){
            logger.info(e.getMessage());
        }
        System.out.println("success");
        return "sunlong";
    }
}
