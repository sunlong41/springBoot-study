package com.sunlong.service.impl;


import com.sunlong.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * 用以测试业务层accountService
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    public void saveAccount() {
        // int a = 1/0;
        System.out.println("执行了保存");
    }
}
