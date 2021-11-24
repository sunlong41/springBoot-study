import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.boot.spring.boot.MyConfiguration;
import spring.boot.spring.boot.entity.Entity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyConfiguration.class})
public class test1 {
    @Autowired
    private Entity vo;

    @Test
    public void test() {
        String s = vo.toString();
        System.out.println(s);
    }

}
