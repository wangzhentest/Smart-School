package com.example.smart_campus_backend.service;

import com.example.smart_campus_backend.dao.AccountMapper;
import com.example.smart_campus_backend.dao.VideoMapper;
import com.example.smart_campus_backend.entity.videos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.List;

@org.springframework.stereotype.Service
public class VideoService {
    @Autowired
    private VideoMapper videoMapper;

    //获取所有录像
    public List<videos> get_videos(){
        List<videos> list = videoMapper.get_videos();
        return list;
    }



}
