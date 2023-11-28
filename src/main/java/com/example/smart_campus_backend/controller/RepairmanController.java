package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.entity.repairmen;
import com.example.smart_campus_backend.service.RepairmanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
public class RepairmanController {
    @Autowired
    private RepairmanService repairmanService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    @CrossOrigin
    @RequestMapping("get_repairmen")
    @ResponseBody
    public List<repairmen> get_repairmen() {
        List<repairmen> list = repairmanService.get_repairmen();
        logger.info("Get Repairmen List ...");
        return list;
    }

}
