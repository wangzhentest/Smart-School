package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.entity.camera_list;
import com.example.smart_campus_backend.entity.cameras;
import com.example.smart_campus_backend.service.CameraService;
import com.example.smart_campus_backend.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@org.springframework.stereotype.Controller
public class CameraController {
    @Autowired
    private CameraService cameraService;
    @Autowired
    private LogService logService;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    @PostMapping(value = "/video-stream", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] streamVideo(@RequestBody byte[] image)
    {
        logger.info("Get video-stream ...");
        return image;
    }

    @CrossOrigin
    @RequestMapping("get_camera_list")
    @ResponseBody
    public List<camera_list> get_camera_list(HttpServletRequest request){
        String areaName = request.getParameter("areaName");
        List<camera_list> list =cameraService.get_camera_list(areaName);
        logger.info("Get Camera List ...");
        return list;
    }
}
