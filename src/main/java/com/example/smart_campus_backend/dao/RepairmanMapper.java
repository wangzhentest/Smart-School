package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.guards;
import com.example.smart_campus_backend.entity.medical_staffs;
import com.example.smart_campus_backend.entity.repairmen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface RepairmanMapper {
    @Select("select * from `smart_campus`.`repairmen`")
    List<repairmen> get_repairmen();

    @Update("UPDATE `repairmen` SET `if_working`=#{if_working} WHERE `id`=#{id}")
    void set_repairmen_working_state(@Param("if_working") String if_working, @Param("id") int id);

    //获取正在值班并且无任务的安保人员
    @Select("select * from `smart_campus`.`repairmen` where repairman_state = 1 and if_working = 1 limit 2")
    List<repairmen> get_no_work_repairmen();

    //获取正在值班的所有安保人员
    @Select("select * from `smart_campus`.`repairmen` where repairman_state = 1 limit 2")
    List<repairmen> get_working_repairmen();
}
