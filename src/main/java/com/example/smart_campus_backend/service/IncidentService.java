package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.IncidentMapper;
import com.example.smart_campus_backend.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@org.springframework.stereotype.Service
@Component
public class IncidentService {
    @Autowired
    private IncidentMapper incidentMapper;
    @Autowired
    private GuardService GuardService;
    @Autowired
    private MedicalStaffService medicalStaffService;
    @Autowired
    private RepairmanService repairmanService;
    @Value("${incident_type.fire}")
    private String fire;
    @Value("incident_type.person_in")
    private String person_in;
    @Value("incident_type.warning")
    private String warning;
    @Value("incident_type.hurting")
    private String hurting;
    @Value("incident_type.device_broke")
    private String device_broke;

    //获取未处理的事故
    public List<incidents> get_untreated_incidents() {
        List<incidents> list = incidentMapper.get_untreated_incidents();
        return list;
    }

    //获取已处理的事故
    public List<incidents> get_treated_incidents() {
        List<incidents> list = incidentMapper.get_treated_incidents();
        return list;
    }

    //新增事故
    public void add_incident(String incident_type, String incident_date,String video, String camera_id) {
        String ids = "";
        if (incident_type.equals(fire) || incident_type.equals(person_in) || incident_type.equals(warning)) {
            List<guards> list = GuardService.get_no_work_guards();
            if (list.size() == 0) {
                list = GuardService.get_working_guards();
                for (int i = 0; i < list.size(); i++) {
                    ids += list.get(i).getGuard_name()+ ';';
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    ids += list.get(i).getGuard_name() + ';';
                }
            }
        } else if (incident_type.equals(hurting)) {
            List<medical_staffs> list = medicalStaffService.get_no_work_medical_staffs();
            if (list.size() == 0) {
                list = medicalStaffService.get_working_medical_staffs();
                for (int i = 0; i < list.size(); i++) {
                    ids += list.get(i).getMedical_staff_name() + ';';
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    ids += list.get(i).getMedical_staff_name() + ';';
                }
            }
        } else if (incident_type.equals(device_broke)) {
            List<repairmen> list = repairmanService.get_no_work_repairmen();
            if (list.size() == 0) {
                list = repairmanService.get_working_repairmen();
                for (int i = 0; i < list.size(); i++) {
                    ids += list.get(i).getRepairman_name() + ';';
                }
            } else {
                for (int i = 0; i < list.size(); i++) {
                    ids += list.get(i).getRepairman_name() + ';';
                }
            }
        }
        incidentMapper.add_incident(incident_type, incident_date, video,camera_id, ids);
    }

    //事故处理完毕
    public void finish_incident(String handle_date, String handle_staff_id,  int id) {
        incidentMapper.finish_incident(handle_date, handle_staff_id, id);
    }

    //委派人员
    public void appoint_staffs(String handle_staff_id,int id){
        incidentMapper.appoint_staffs(handle_staff_id,id);
    }
}
