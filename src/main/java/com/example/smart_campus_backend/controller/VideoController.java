package com.example.smart_campus_backend.controller;

import com.example.smart_campus_backend.entity.videos;
import com.example.smart_campus_backend.service.LogService;
import com.example.smart_campus_backend.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class VideoController {
    @Autowired
    private VideoService videoService;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

    //获取所有录像
    @CrossOrigin
    @RequestMapping("get_videos")
    @ResponseBody
    public List<videos> get_videos() {
        List<videos> list = videoService.get_videos();
        logger.info("Get A Video ...");
        return list;
    }

    @CrossOrigin
    @GetMapping("/video")
    @ResponseBody
    public ResponseEntity<byte[]> getVideo(HttpServletRequest request) throws IOException {
        String video_name = request.getParameter("video_name");
        File file = new File("/home/ubuntu/videos/" + video_name + ".mp4");
        byte[] bytes = Files.readAllBytes(file.toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "video/mp4");
        headers.set("Content-Length", String.valueOf(bytes.length));
        headers.set("Content-Disposition", "inline; filename=\"" + file.getName() + "\"");
        logger.info("video_"+video_name+" has be watched");
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }


}
