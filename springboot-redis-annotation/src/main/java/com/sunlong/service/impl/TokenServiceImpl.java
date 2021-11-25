package com.sunlong.service.impl;

import cn.hutool.core.text.StrBuilder;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.sunlong.util.RedisUtil;
import com.sunlong.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 创建token
     *
     * @return
     */
    @Override
    public String createToken() {
        String str = RandomUtil.randomString(5);
        StrBuilder token = new StrBuilder();
        try {
            token.append("SUNLONG").append(str);
            redisUtil.setEx(token.toString(), token.toString(),10000L);
            boolean notEmpty = StrUtil.isNotEmpty(token.toString());
            if (notEmpty) {
                return token.toString();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
    /**
     * 检验token
     *
     * @param request
     * @return
     */
    @Override
    public boolean checkToken(HttpServletRequest request) throws Exception {
        String token = request.getHeader("TOKEN_NAME");
        if (StrUtil.isBlank(token)) {// header中不存在token
            token = request.getParameter("TOKEN_NAME");
            if (StrUtil.isBlank(token)) {// parameter中也不存在token
                throw new Exception("TOKEN_NAME不存在1");
            }
        }
        /**
         * token 机制，每次接口请求前先获取一个 token，然后再下次请求的时候在请求的 header
         * 体中加上这个 token，后台进行验证，如果验证通过删除 token，下次请求再次判断 token
         */
        if (!redisUtil.exists(token)) {//redis里面不存在，上一次相同token请求过，该token缓存已被清除
            throw new Exception("重复操作");
        }
        boolean remove = redisUtil.remove(token);//token存在，则删除该token
        if (!remove) {//token能够删除
            throw new Exception("重复操作");
        }
        return true;
    }
}
