package com.example.smart_campus_backend.service;


import com.example.smart_campus_backend.dao.AccountMapper;
import com.example.smart_campus_backend.entity.accounts;
import com.example.smart_campus_backend.entity.users;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class LoginService {
    @Autowired
    private AccountMapper accountMapper;

    //检查用户名和密码是否正确,正确则返回用户信息
    public users Login(String account ,String pwd){
        accounts Account = accountMapper.Login(account,pwd);
        if (Account != null){
            users user = accountMapper.getUser(Account.getUser_id());
            return user;
        }else {
            return null;
        }
    }



}
