package com.example.smart_campus_backend.controller;


import com.example.smart_campus_backend.entity.summaries;
import com.example.smart_campus_backend.service.IncidentService;
import com.example.smart_campus_backend.service.SummaryService;
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
public class SummaryController {
    @Autowired
    private SummaryService summaryService;
    @Autowired
    private IncidentService incidentService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    //获取事故处理表
    @CrossOrigin
    @RequestMapping("get_summaries")
    @ResponseBody
    public List<summaries> get_summaries(){
        List<summaries> list = summaryService.get_summaries();
        logger.info("Get Summaries List ...");
        return list;
    }

    @CrossOrigin
    @RequestMapping("get_summary")
    @ResponseBody
    public summaries get_summary(HttpServletRequest request){
        int incident_id = Integer.parseInt(request.getParameter("incident_id"));
        summaries summary = summaryService.get_summary(incident_id);
        logger.info("Get A Summary ...");
        return summary;
    }

    @CrossOrigin
    @RequestMapping("get_summary_by_id")
    @ResponseBody
    public summaries get_summary_by_id(HttpServletRequest request){
        int incident_id = Integer.parseInt(request.getParameter("incident_id"));
        summaries summary = summaryService.get_summary_by_id(incident_id);
        logger.info("Get Summary "+incident_id);
        return summary;
    }

    @CrossOrigin
    @RequestMapping("add_summary")
    @ResponseBody
    public void add_summary(HttpServletRequest request){
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = nowDateTime.format(formatter);
        int incident_id = Integer.parseInt(request.getParameter("incident_id"));
        String incident_type = request.getParameter("incident_type");
        String occur_date = request.getParameter("occur_date");
        String occur_place = request.getParameter("occur_place");
        String incident_reason = request.getParameter("incident_reason");
        String dispose_staff_id = request.getParameter("dispose_staff_id");
        String expenditures = request.getParameter("expenditures");
        String potential_risk = request.getParameter("potential_risk");
        summaryService.add_summary(incident_id,incident_type,occur_date,occur_place,incident_reason,date,dispose_staff_id,expenditures,potential_risk);
        incidentService.finish_incident(date, dispose_staff_id, incident_id);//回放的设置还需要完善
        logger.info("Add A Summary.");
    }
}


