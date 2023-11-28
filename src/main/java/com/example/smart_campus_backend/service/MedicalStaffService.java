package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.GuardMapper;
import com.example.smart_campus_backend.dao.MedicalStaffMapper;
import com.example.smart_campus_backend.entity.guards;
import com.example.smart_campus_backend.entity.medical_staffs;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class MedicalStaffService {
    @Autowired
    private MedicalStaffMapper medicalStaffMapper;

    public List<medical_staffs> get_medical_staffs() {
        List<medical_staffs> list = medicalStaffMapper.get_medical_staffs();
        return list;
    }

    //获取正在值班并且无任务的安保人员
    public List<medical_staffs> get_no_work_medical_staffs() {
        List<medical_staffs> list = medicalStaffMapper.get_no_work_medical_staffs();
        return list;
    }

    //获取正在值班的所有安保人员
    public List<medical_staffs> get_working_medical_staffs() {
        List<medical_staffs> list = medicalStaffMapper.get_working_medical_staffs();
        return list;
    }

    //修改安保人员的工作状态
    public void set_guard_working_state(String if_working, int id) {
        medicalStaffMapper.set_medical_staff_working_state(if_working, id);
    }
}
