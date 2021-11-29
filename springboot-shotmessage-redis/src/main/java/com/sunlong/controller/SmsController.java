package com.sunlong.controller;

import com.aliyuncs.utils.StringUtils;
import com.sunlong.serrvice.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@CrossOrigin    //跨域支持
public class SmsController {
    @Autowired
    private SendSms sendSms;

    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/send/{phone}")
    public String code(@PathVariable("phone") String phone) {
        //调用发送方法，模拟真实业务，redis
        String code = (String) redisTemplate.opsForValue().get(phone);
        if (!StringUtils.isEmpty(code)) {
            return phone + ":" + code + "已存在，还没有过期";
        }
        // 生成验证码并且存储到 redis 中
        code = UUID.randomUUID().toString().substring(0, 5);
        HashMap<String, Object> param = new HashMap<>();
        param.put("code", code);
        boolean isSend = sendSms.send(phone, "SMS_126360192", param);
        if (isSend) {
            redisTemplate.opsForValue().set(phone, code, 300, TimeUnit.SECONDS);
            return phone + ":" + code + "发送成功！";
        } else {
            return "发送失败！";
        }
    }
}