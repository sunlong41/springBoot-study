package LambdaTest;

import LambdaTest.entity.Utils;
import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;

import java.awt.*;
import java.nio.file.DirectoryStream;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.*;


public class Lambda {
    /**
     * Java 8 允许你使用 :: 关键字来传递方法或者构造函数引用，上面的代码展示了如何引用一个静态方法，我们也可以引用一个对象的方法
     */
    @Test
    public  void test1(){
        //测试非静态方法调用
        Consumer<Utils> util1 = Utils::util1;
        util1.accept(new Utils());
    }

    @Test
    public  void test2(){
        //测试静态方法调用
        Runnable util2 = Utils::util2;
        util2.run();
    }
    @Test
    public  void test3(){
        //测试调用空参构造
        Runnable runnable = Utils::new;
        runnable.run();
    }
    @Test
    public  void test4(){
        BiFunction<String, String, Utils> runnable = Utils::new;
        Utils utils = runnable.apply("1", "2");
        System.out.println(utils.toString());
    }

    private int x;
    private int y;
    @Test
    public  void test5(){
        IntConsumer tConsumer = (z) -> {
            x = 1;
            System.out.println(x);
            System.out.println(z);
        };
        tConsumer.accept(1);
    }

    @Test
    public  void test6(){
        /**
         * Predicate接口
         *
         * Predicate 接口只有一个参数，返回boolean类型。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）
         */
        Predicate<String> predicate = (s) -> s.length() > 0;
        boolean b = predicate.test("");
        System.out.println(b);
        boolean xx = predicate.negate().test("xx");
        System.out.println(xx);

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<String> isEmpty = String::isEmpty;
        boolean b1 = isEmpty.test("");
        System.out.println(b1);
    }

    @Test
    public  void test7(){
        /**
         * Function 接口
         *
         * Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）：
         */
        Function<String, String> charAt = Utils::util2;
        String s = charAt.apply("sssss");
        System.out.println(s);

    }

    @Test
    public  void test8(){
        Function<String[], List<String>> list = Arrays::asList;
        String[] strings = {"1","2","3"};
        List<String> nums = list.apply(strings);
        //  第一种遍历方式：

        nums.forEach(s->{
            System.out.println(s);
        });
        System.out.println("=====================");

        //第二种遍历方式：
        nums.forEach(s-> System.out.println(s));

        System.out.println("==========================");
        //第三种遍历方式：
        nums.forEach(System.out::println);
    }
}
