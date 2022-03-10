package com.sunlong;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@SpringBootApplication
public class App {

/*
    public static void main(String[] args) {


        try {
            long begin = System.currentTimeMillis();
            SpringApplication.run(App.class, args);
            long end = System.currentTimeMillis();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
*/

    public static void main(String[] args) {
        List a = new ArrayList();
        a.add(1);
        a.add(12);
        a.add(14);
        a.add(15);

        a.forEach(x->method((Integer) x));
        System.out.println(a);

        
       // a.stream().map(x->method((Integer) x)).collect(Collectors.toList());
        //List collect = (List) a.stream().map(x -> method((Integer) x)).collect(Collectors.toList());
        //System.out.println(collect);
    }

    private static void method(int x) {
          x++;
    }


}
