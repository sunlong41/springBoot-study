package com.sunlong.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.sunlong.anno.AutoIdempotent;
import com.sunlong.service.TestService;
import com.sunlong.service.TokenService;
import com.sunlong.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BusinessController {
    @Resource
    private TokenService tokenService;
    @Resource
    private TestService testService;
    @GetMapping("/get/token")
    public String  getToken(){
        String token = tokenService.createToken();
        if (StrUtil.isNotEmpty(token)) {
            ResultVo resultVo = new ResultVo();
            resultVo.setCode(000000);
            resultVo.setMessage("success");
            resultVo.setData(token);
            return JSONUtil.toJsonStr(resultVo);
        }
        return StrUtil.EMPTY;
    }
    @AutoIdempotent
    @GetMapping("/test/Idempotence")
    public String testIdempotence() {
        String businessResult = testService.doSomeThing();
        if (StrUtil.isNotEmpty(businessResult)) {
            ResultVo successResult = ResultVo.getSuccessResult(businessResult);
            return JSONUtil.toJsonStr(successResult);
        }
        return StrUtil.EMPTY;
    }
}
