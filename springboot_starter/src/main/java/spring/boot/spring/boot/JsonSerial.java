package spring.boot.spring.boot;

import com.alibaba.fastjson.JSONObject;

public class JsonSerial {
    public <T> String serial(T t){
        return JSONObject.toJSONString(t);
    }
}
