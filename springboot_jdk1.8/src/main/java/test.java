import LambdaTest.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.boot.spring.boot.JsonSerial;
import spring.boot.spring.boot.MyAutoConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyAutoConfiguration.class})
public class test {
    @Autowired
    private JsonSerial jsonSerial;

    @Autowired
    private ApplicationContext aa;

    public static void main(String[] args) {
        JsonSerial a = new JsonSerial();
        String s = a.serial(new Person("1", "22"));
        System.out.println(s);
    }

    @Test
    public void test1(){
        String s = jsonSerial.serial(new Person("1", "22"));
        System.out.println(s);
    }
    @Test
    public void test2(){
        JsonSerial jsonSerial = (JsonSerial) aa.getBean("jsonSerial");
        String s = jsonSerial.serial(new Person("1", "22"));
        System.out.println(s);
    }

    @Test
    public void test3(){

    }
}
