package com.example.smart_campus_backend.controller;


import com.example.smart_campus_backend.entity.guards;
import com.example.smart_campus_backend.service.GuardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
public class GuardController {
    @Autowired
    private GuardService guardService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    @CrossOrigin
    @RequestMapping("get_guards")
    @ResponseBody
    public List<guards> get_guards(){
        List<guards> list = guardService.get_guards();
        logger.info("Get Guards List ...");
        return list;
    }

}
