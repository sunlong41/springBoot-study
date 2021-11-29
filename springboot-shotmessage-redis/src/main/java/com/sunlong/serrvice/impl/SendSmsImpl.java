package com.sunlong.serrvice.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.sunlong.serrvice.SendSms;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SendSmsImpl implements SendSms {
    /**
     * 发送短信验证码
     * @param phoneNum  手机号
     * @param templateCode  模板号
     * @param code   验证码
     * @return
     */
    @Override
    public Boolean send(String phoneNum, String templateCode, Map<String, Object> code) {
        // 连接阿里云
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "", "");
        IAcsClient client = new DefaultAcsClient(profile);
        // 构建请求
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        // 这些内容不要动，是人家阿里爸爸弄出来的，咱不用管
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        // 自己的内容,此处 SendSms 为发送验证码
        request.setAction("SendSms");
        //自定义的参数(手机号，验证码，签名,模板! )
        //这是我的内容，请结合你的情况修改为你的东西！！！
        request.putQueryParameter( "PhoneNumbers",phoneNum);
        request.putQueryParameter( "SignName","行摄时光");
        request.putQueryParameter( "TemplateCode",templateCode);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(code));
        try {
            CommonResponse response = client.getCommonResponse(request);
            // 在控制台上打印出返回信息
            System.out.println(response.getData());
            // 返回请求信息是否成功
            return response.getHttpResponse().isSuccess();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return false;
    }
}