package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.SummaryMapper;
import com.example.smart_campus_backend.entity.summaries;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class SummaryService {
    @Autowired
    private SummaryMapper summaryMapper;

    //获取事故总结表
    public List<summaries> get_summaries(){
        List<summaries> list = summaryMapper.get_summaries();
        return list;
    }

    public summaries get_summary(int incident_id){
        summaries summary = summaryMapper.get_summary(incident_id);
        return summary;
    }

    public summaries get_summary_by_id(int incident_id){
        summaries summary = summaryMapper.get_summary_by_id(incident_id);
        return summary;
    }


    public void add_summary(int incident_id,String incident_type,String occur_date,String occur_place,String incident_reason,String dispose_date,String dispose_staff_id,String expenditures,String potential_risk){
        summaryMapper.add_summary(incident_id,incident_type,occur_date,occur_place,incident_reason,dispose_date,dispose_staff_id,expenditures,potential_risk);
    }


}
