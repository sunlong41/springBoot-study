package com.sunlong.serrvice;

import java.util.Map;

public interface SendSms {
    /**
     * 发送短信验证码
     * @param phoneNum  手机号
     * @param templateCode  模板号
     * @param code   验证码
     * @return
     */
    public Boolean send(String phoneNum, String templateCode, Map<String,Object> code);
}
