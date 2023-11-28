package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.accounts;
import com.example.smart_campus_backend.entity.messages;
import com.example.smart_campus_backend.entity.users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface MessageMapper {

    //获取警告信息
    @Select("select * from `smart_campus`.`messages`")
    List<messages> get_messages();

    //新增警告信息
    @Insert("INSERT INTO messages (`occur_date`,`occur_area`, `occur_place`, `camera_id`, `alarm_reason`)\n" +
            "VALUES(#{occur_date},(SELECT camera_area FROM camera WHERE camera_id = #{camera_id}),(SELECT camera_position FROM camera WHERE camera_id = #{camera_id}),#{camera_id},#{alarm_reason});")
    void add_message(@Param("occur_date") String occur_date,@Param("camera_id") String camera_id,@Param("alarm_reason") String alarm_reason);

    //获取未提醒的警告信息
    @Select("select * from `smart_campus`.`messages` where if_warn='未提醒' ")
    List<messages> get_not_reminded_messages();

    //设置警告信息已提醒
    @Update("UPDATE `messages` SET `if_warn`='已提醒' WHERE `id`=#{id}")
    void remind_message(@Param("id") int id);

    //删除信息
    @Delete("DELETE FROM `messages` WHERE `id`=#{id}")
    void delete_message(@Param("id") int id);
}
