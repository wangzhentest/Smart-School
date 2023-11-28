package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.ReportMapper;
import com.example.smart_campus_backend.entity.reports;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ReportService {
    @Autowired
    private ReportMapper reportMapper;

    //获取所有反馈
    public List<reports> get_reports(){
        List<reports> list = reportMapper.get_reports();
        return list;
    }

    //新增反馈
    public void add_report(String report_type,String report_date, String report_content,String report_person_id,String whether_dispose,String other){
        reportMapper.add_report(report_type,report_date,report_content,report_person_id,whether_dispose,other);
    }

    //反馈处理完毕
    public void finish_report(String dispose_staff_id,String dispose_date,int id){
        reportMapper.finish_report(dispose_staff_id,dispose_date,id);
    }
}
