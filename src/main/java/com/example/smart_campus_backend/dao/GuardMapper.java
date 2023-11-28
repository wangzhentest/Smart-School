package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.guards;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface GuardMapper {
    @Select("select * from `smart_campus`.`guards`")
    List<guards> get_guards();

    @Update("UPDATE `guards` SET `if_working`=#{if_working} WHERE `id`=#{id}")
    void set_guard_working_state(@Param("if_working") String if_working,@Param("id") int id);

    //获取正在值班并且无任务的安保人员
    @Select("select * from `smart_campus`.`guards` where if_working = 1 limit 2")
    List<guards> get_no_work_guards();

    //获取正在值班的所有安保人员
    @Select("select * from `smart_campus`.`guards` where guard_state = 1 limit 2")
    List<guards> get_working_guards();

}
