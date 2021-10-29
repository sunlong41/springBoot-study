package LambdaTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class LambdaCollections {
    /**
     * stream
     * 表示能应用在一组元素上一次执行的操作序列。
     * Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，这样你就可以将多个操作依次串起来。
     * Stream 的创建需要指定一个数据源，比如 java.util.Collection的子类，List或者Set， Map不支持。Stream的操作可以串行执行或者并行执行。
     * Java 8扩展了集合类，可以通过 Collection.stream() 或者 Collection.parallelStream() 来创建一个Stream。
     */
    private static List list = new ArrayList();
    private static List<Integer> list1 = new ArrayList<>();
    static{
        list.add(1);
        list.add(2);
        list.add("3");
        list.add(true);
        list.add('1');
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
    }

    @Test
    public void test1(){
        //简单便利
        list.forEach(System.out::println);
        System.out.println("-----------------------");
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.stream().forEach(s->{s=s+1;
            System.out.println(s);
        });
        //由于是以流方式，所以怎么操作也不改变原来的集合
        System.out.println("-----------------------");
        list3.forEach(System.out::println);
    }

    @Test
    public void test2(){
        //filter 过滤
        list.stream().filter(s -> s instanceof Integer).forEach(System.out::println);
        //System.out.println("----------------------------------");
       // list1.stream().filter(s ->{ return s instanceof Integer;}).forEach(System.out::println);
    }

    @Test
    public void test3(){
        //并行Streams
        //由于默认并行流使用的是全局的线程池,线程数量是根据cpu核数设置的,所以如果某个操作占用了线程,将影响全局其他使用并行流的操作;
        //所以折中的方案是自定义线程池来执行某个并行流操作;
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        List listByPage = new CopyOnWriteArrayList();
        forkJoinPool.execute(() -> {
            listByPage.parallelStream().forEach(str -> {

            });
        });
    }

}
