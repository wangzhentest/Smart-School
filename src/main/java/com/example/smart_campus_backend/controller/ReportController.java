package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.entity.reports;
import com.example.smart_campus_backend.service.ReportService;
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
public class ReportController {
    @Autowired
    private ReportService reportService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    @CrossOrigin
    @RequestMapping("get_reports")
    @ResponseBody
    public List<reports> get_reports(){
        List<reports> list = reportService.get_reports();
        logger.info("Get Report Mesaage ...");
        return list;
    }

    @CrossOrigin
    @RequestMapping("add_report")
    @ResponseBody
    public void add_report(HttpServletRequest request){
        String report_type = request.getParameter("report_type");
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = nowDateTime.format(formatter);
        String report_content = request.getParameter("report_content");
        String report_person_id = request.getParameter("report_person_id");
        String whether_dispose = ("未处理");
        String other = request.getParameter("other");
        reportService.add_report(report_type,date,report_content,report_person_id,whether_dispose,other);
        logger.info("Add a Report ...");
    }

    @CrossOrigin
    @RequestMapping("finish_report")
    @ResponseBody
    public void finish_report(HttpServletRequest request){
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = nowDateTime.format(formatter);
        String dispose_staff_id = request.getParameter("dispose_staff_id");
        int id = Integer.parseInt(request.getParameter("id"));
        reportService.finish_report(dispose_staff_id,date,id);
        logger.info("Finished one Report.");
    }
}
