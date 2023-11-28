package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.MedicalStaffMapper;
import com.example.smart_campus_backend.dao.RepairmanMapper;
import com.example.smart_campus_backend.entity.guards;
import com.example.smart_campus_backend.entity.repairmen;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class RepairmanService {
    @Autowired
    private RepairmanMapper repairmanMapper;

    public List<repairmen> get_repairmen() {
        List<repairmen> list = repairmanMapper.get_repairmen();
        return list;
    }

    //获取正在值班并且无任务的安保人员
    public List<repairmen> get_no_work_repairmen() {
        List<repairmen> list = repairmanMapper.get_no_work_repairmen();
        return list;
    }

    //获取正在值班的所有安保人员
    public List<repairmen> get_working_repairmen() {
        List<repairmen> list = repairmanMapper.get_working_repairmen();
        return list;
    }

    //修改安保人员的工作状态
    public void set_repairmen_working_state(String if_working, int id) {
        repairmanMapper.set_repairmen_working_state(if_working, id);
    }
}
