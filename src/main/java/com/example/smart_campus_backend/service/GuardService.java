package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.GuardMapper;
import com.example.smart_campus_backend.entity.guards;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class GuardService {
    @Autowired
    private GuardMapper guardMapper;

    public List<guards> get_guards(){
        List<guards> list = guardMapper.get_guards();
        return list;
    }

    //获取正在值班并且无任务的安保人员
    public List<guards> get_no_work_guards(){
        List<guards> list = guardMapper.get_no_work_guards();
        return list;
    }

    //获取正在值班的所有安保人员
    public List<guards> get_working_guards(){
        List<guards> list = guardMapper.get_working_guards();
        return list;
    }

    //修改安保人员的工作状态
    public void set_guard_working_state(String if_working,int id){
        guardMapper.set_guard_working_state(if_working,id);
    }


}
