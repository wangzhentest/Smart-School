package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.users;
import com.example.smart_campus_backend.entity.videos;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface VideoMapper { ;

    //获取所有录像
    @Select("select * from `smart_campus`.`videos`")
    List<videos> get_videos();






}
