package com.example.smart_campus_backend.dao;

import com.example.smart_campus_backend.entity.medical_staffs;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface MedicalStaffMapper {

    @Select("select * from `smart_campus`.`medical_staffs`")
    List<medical_staffs> get_medical_staffs();

    @Update("UPDATE `medical_staffs` SET `if_working`=#{if_working} WHERE `id`=#{id}")
    void set_medical_staff_working_state(@Param("if_working") String if_working, @Param("id") int id);

    //获取正在值班并且无任务的医护人员
    @Select("select * from `smart_campus`.`medical_staffs` where if_working = 1 limit 2")
    List<medical_staffs> get_no_work_medical_staffs();

    //获取正在值班的所有医护人员
    @Select("select * from `smart_campus`.`medical_staffs` where medical_staff_state = 1 limit 2")
    List<medical_staffs> get_working_medical_staffs();
}
