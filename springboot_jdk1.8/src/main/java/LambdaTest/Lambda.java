package LambdaTest;

import LambdaTest.entity.Utils;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntConsumer;


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


}
