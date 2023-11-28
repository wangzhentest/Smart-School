package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.entity.logs;
import com.example.smart_campus_backend.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@org.springframework.stereotype.Controller
public class LogController {
    @Autowired
    private LogService logService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    //获取所有日志
    @CrossOrigin
    @RequestMapping("get_logs")
    @ResponseBody
    public List<logs> get_logs(){
        List<logs> list = logService.get_logs();
        logger.info("Get Log List ...");
        return list;
    }

    //获取某人的日志
    @CrossOrigin
    @RequestMapping("get_somebody_logs")
    @ResponseBody
    public List<logs> get_somebody_logs(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        List<logs> list = logService.get_somebody_logs(user_id);
        logger.info("Get Somebody Logs ...");
        return list;
    }

    //增加日志
    @CrossOrigin
    @RequestMapping("add_log")
    @ResponseBody
    public void add_log(HttpServletRequest request){
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String add_date = nowDateTime.format(formatter);
        String change_type = request.getParameter("change_type");
        int change_id = Integer.parseInt(request.getParameter("change_id"));
        String user_id = request.getParameter("user_id");
        String operate = request.getParameter("operate");
        logService.add_log(change_type,change_id,add_date,user_id,operate);
        logger.info("Add a log ...");
    }


}
