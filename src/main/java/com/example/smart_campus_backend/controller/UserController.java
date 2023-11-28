package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.entity.users;
import com.example.smart_campus_backend.service.AccountService;
import com.example.smart_campus_backend.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@org.springframework.stereotype.Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());
    @Autowired
    private UserService userService;

    //获取所有用户信息
    @CrossOrigin
    @RequestMapping("get_users")
    @ResponseBody
    public List<users> get_users(){
        List<users> list = userService.get_users();
        return list;
    }

    //用户上线
    @CrossOrigin
    @RequestMapping("go_online")
    @ResponseBody
    public void go_online(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        logger.info(user_id+" is online");
        userService.go_online(user_id);
    }

    //用户下线
    @CrossOrigin
    @RequestMapping("down_online")
    @ResponseBody
    public void down_online(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        logger.info(user_id+" is offline");
        userService.down_online(user_id);
    }

    @CrossOrigin
    @RequestMapping("get_pwd")
    @ResponseBody
    public Integer get_pwd(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        int pwd = Integer.parseInt(userService.get_pwd(user_id));
        System.out.println(pwd);
        return pwd;

    }

}
