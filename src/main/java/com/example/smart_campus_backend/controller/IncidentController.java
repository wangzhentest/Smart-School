package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.entity.incidents;
import com.example.smart_campus_backend.service.IncidentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@org.springframework.stereotype.Controller
public class IncidentController {
    @Autowired
    private IncidentService incidentService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    //获取未处理的事故
    @CrossOrigin
    @RequestMapping("get_untreated_incidents")
    @ResponseBody
    public List<incidents> get_untreated_incidents() {
        List<incidents> list = incidentService.get_untreated_incidents();
//        logger.info("Get Untreated Incidents ...");
        return list;
    }

    //获取已处理的事故
    @CrossOrigin
    @RequestMapping("get_treated_incidents")
    @ResponseBody
    public List<incidents> get_treated_incidents() {
        List<incidents> list = incidentService.get_treated_incidents();
//        logger.info("Get Treated Incidents ...");
        return list;
    }

    //新增事故
    @CrossOrigin
    @RequestMapping("add_incident")
    @ResponseBody
    public void add_incident(HttpServletRequest request) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = nowDateTime.format(formatter);
        String incident_type = request.getParameter("incident_type");
        String camera_id = request.getParameter("camera_id");
        String video = request.getParameter("video");
        incidentService.add_incident(incident_type, date, video, camera_id);
        logger.info("Add an Incident ...");
        System.out.println(video);
    }

    //委派人员
    @CrossOrigin
    @RequestMapping("appoint_staffs")
    @ResponseBody
    public void appoint_staffs(HttpServletRequest request) {
        int incidentId = Integer.parseInt(request.getParameter("incidentId"));
        String staffs_list = request.getParameter("staffs_list");
        incidentService.appoint_staffs(staffs_list,incidentId);
        logger.info("Appointing Staffs ...");
    }

    //事故处理完毕
    @CrossOrigin
    @RequestMapping("finish_incident")
    @ResponseBody
    public void finish_incident(HttpServletRequest request) {
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String handle_date = nowDateTime.format(formatter);
        String handle_staff_id = request.getParameter("handle_staff_id");
        int id = Integer.parseInt(request.getParameter("id"));
        incidentService.finish_incident(handle_date, handle_staff_id, id);
    }
}
