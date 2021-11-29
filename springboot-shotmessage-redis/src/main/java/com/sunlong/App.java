package com.sunlong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App {

    public static void main(String[] args) {


        try {
            long begin = System.currentTimeMillis();
            SpringApplication.run(App.class, args);
            long end = System.currentTimeMillis();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
