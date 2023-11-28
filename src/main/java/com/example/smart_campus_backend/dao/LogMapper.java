package com.example.smart_campus_backend.dao;

import com.example.smart_campus_backend.entity.logs;
import com.example.smart_campus_backend.entity.messages;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository
public interface LogMapper {

    //获取所有日志
    @Select("select * from `smart_campus`.`logs`")
    List<logs> get_logs();

    //获取某人的日志
    @Select("select * from `smart_campus`.`logs` where user_id = #{user_id}")
    List<logs> get_somebody_logs(@Param("user_id") String user_id);

    //增加日志
    @Insert("INSERT INTO `logs` (`change_type`, `change_id`, `change_date`, `user_id` ,`operate`) VALUES (#{change_type},#{change_id},#{change_date},#{user_id},#{operate})")
    void add_log(@Param("change_type") String change_type,@Param("change_id") int change_id,@Param("change_date") String change_date,@Param("user_id") String user_id,@Param("operate") String operate);
}
