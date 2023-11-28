package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.MessageMapper;
import com.example.smart_campus_backend.entity.messages;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    //获取警告信息
    public List<messages> get_messages(){
        List<messages> list = messageMapper.get_messages();
        return list;
    }

    //新增警告信息
    public void add_message(messages message){
        messageMapper.add_message(message.getOccur_date(),message.getCamera_id(),message.getAlarm_reason());
    }

    //获取未提醒的警告信息
    public List<messages> get_not_reminded_messages(){
        List<messages> list = messageMapper.get_not_reminded_messages();
        return list;
    }

    //设置警告信息已提醒
    public void remind_message(int id){
        messageMapper.remind_message(id);
    }

    //删除信息
    public void delete_message(int id){
        messageMapper.delete_message(id);
    }


}
