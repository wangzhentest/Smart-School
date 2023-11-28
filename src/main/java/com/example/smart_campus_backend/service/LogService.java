package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.LogMapper;
import com.example.smart_campus_backend.entity.logs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class LogService {
    @Autowired
    private LogMapper logMapper;

    //获取所有日志
    public List<logs> get_logs(){
        List<logs> list = logMapper.get_logs();
        return list;
    }

    //获取某人的日志
    public List<logs> get_somebody_logs(String user_id){
        List<logs> list = logMapper.get_somebody_logs(user_id);
        return list;
    }

    //增加日志
    public void add_log(String change_type,int change_id,String change_date, String user_id,String operate){
        logMapper.add_log(change_type,change_id,change_date,user_id,operate);
    }


}
