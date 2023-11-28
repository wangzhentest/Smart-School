package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.camera_list;
import com.example.smart_campus_backend.entity.cameras;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface CameraMapper {

    @Select("select * from `smart_campus`.`camera` WHERE `camera_area` = #{areaName} ")
    List<camera_list> get_camera_list(@Param("areaName") String areaName);
}
