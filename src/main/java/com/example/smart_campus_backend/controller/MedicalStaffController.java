package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.entity.medical_staffs;
import com.example.smart_campus_backend.service.MedicalStaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@org.springframework.stereotype.Controller
public class MedicalStaffController {
    @Autowired
    private MedicalStaffService medicalStaffService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    @CrossOrigin
    @RequestMapping("get_medical_staffs")
    @ResponseBody
    public List<medical_staffs> get_medical_staffs(){
        List<medical_staffs> list = medicalStaffService.get_medical_staffs();
        logger.info("Get Medical Staffs ...");
        return list;
    }

}
