package com.example.smart_campus_backend.service;


import com.example.smart_campus_backend.dao.CameraMapper;
import com.example.smart_campus_backend.entity.camera_list;
import com.example.smart_campus_backend.entity.cameras;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class CameraService {
    @Autowired
    private CameraMapper cameraMapper;

    public List<camera_list> get_camera_list(String areaName){
        List<camera_list> list =cameraMapper.get_camera_list(areaName);
        return list;
    }
}
