package com.sunlong.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.jmx.snmp.Timestamp;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test3 {
/*    public static void main(String[] args) {
        BigDecimal a = BigDecimal.ZERO;
        for (int i = 0; i < 2; i++) {
            a=a.add(BigDecimal.ONE);
        }
        System.out.println(a);
    }*/


//    public static void main(String[] args) {
//
//        int a =0;
//        int b= 1;
//        int d=0;
//        if(a==-1){
//            d=1;
//        }else if(a==0){
//            d=2;
//        }else if(a==0){
//            d=3;
//        }
//
//
//
//        String s = String.valueOf("");
//        System.out.println(d);
//    }

//    public static void main(String[] args) {
//
//    String a ="{xx:''}";
//        JSONObject obj = JSONObject.parseObject(a);
//        System.out.println(obj.getBigDecimal("xx"));
//
//    }

    public static void main(String[] args) throws ParseException, UnsupportedEncodingException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:dd");
        Date date = sdf.parse("2022-01-22 16:15:00");
        //URLDecoder.decode("");
        String xx = URLEncoder.encode("孙龙XXXXX","utf8");
        System.out.println(xx);

        Long now = (date).getTime();
        System.out.println(now);
        long l=600000L;

        Timestamp timestamp = new Timestamp(l);

        System.out.println(timestamp);


    }
}
