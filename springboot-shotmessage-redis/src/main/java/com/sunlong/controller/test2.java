package com.sunlong.controller;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class test2 {

    public static void main(String[] args) {
       VO v = new VO();
       List a = new ArrayList();
       v.setX(a);
       a.add(1);
        System.out.println(JSONObject.toJSONString(v));
    }

}
