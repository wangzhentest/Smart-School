package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.UserMapper;
import com.example.smart_campus_backend.entity.users;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //获取所有用户信息
    public List<users> get_users(){
        List<users> list = userMapper.get_users();
        return list;
    }

    //用户上线
    public void go_online(String user_id){
        userMapper.go_online(user_id);
    }

    //用户下线
    public void down_online(String user_id){
        userMapper.down_online(user_id);
    }

    public String get_pwd(String user_id) {
        String pwd = userMapper.get_pwd(user_id);
        return pwd;
    }
}
