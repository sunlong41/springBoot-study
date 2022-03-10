package com.sunlong.controller;

import java.text.SimpleDateFormat;
import java.util.*;

public class test {

    private static boolean isEmpty(final Collection collection){
        return collection==null||collection.isEmpty();
    }
    public static boolean isNotEmpty(final Collection collection){
        return !isEmpty(collection);
    }

    public static void main(String[] args) {
        List a = new ArrayList<>();
        a.add(1);
        System.out.println(a!=null&&a.size()>0);
        //System.out.println(isNotEmpty(a)&&a.size()>0);
    }

//    public static void main(String[] args) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(new Date());
//        c.add(5,-2);
//        String s = new SimpleDateFormat("yyyyMMdd").format(c.getTime());
//        System.out.println(s);
//    }

}
