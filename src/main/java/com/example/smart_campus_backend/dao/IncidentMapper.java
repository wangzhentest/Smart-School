package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.accidents;
import com.example.smart_campus_backend.entity.incidents;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface IncidentMapper {

    //获取未处理的事故
    @Select("select * from `smart_campus`.`incidents` where if_handle = '未处理'")
    List<incidents> get_untreated_incidents();

    //获取已处理的事故
    @Select("select * from `smart_campus`.`incidents` where if_handle = '已处理'")
    List<incidents> get_treated_incidents();

    //新增事故
    @Insert("INSERT INTO `incidents` (`incident_type`, `incident_date`, `incident_position`, `camera_id`, `handle_staff_id`, `video`) VALUES (" +
            " #{incident_type}, #{incident_date}, (SELECT camera_position From camera where camera_id=#{camera_id}), #{camera_id},#{handle_staff_id},#{video})")
    void add_incident(@Param("incident_type") String incident_type,@Param("incident_date") String incident_date,@Param("video") String video,@Param("camera_id") String camera_id,@Param("handle_staff_id") String handle_staff_id);

    //事故处理完毕
    @Update("UPDATE `incidents` SET `if_handle`='已处理', `handle_date`=#{handle_date}, `handle_staff_id`=#{handle_staff_id} WHERE `id`=#{id}")
    void finish_incident(@Param("handle_date") String handle_date,@Param("handle_staff_id") String handle_staff_id,@Param("id") int id);

    @Update("UPDATE `incidents` SET `handle_staff_id`=#{handle_staff_id} WHERE `id`=#{id}")
    void appoint_staffs(@Param("handle_staff_id") String handle_staff_id,@Param("id") int id);

}
