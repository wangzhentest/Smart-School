package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.reports;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface ReportMapper {

    @Select("select * from `smart_campus`.`reports`")
    List<reports> get_reports();

    @Insert("INSERT INTO `reports` (`report_type`, `report_date`, `report_content`, `report_person_id`, `whether_dispose`, `other`) VALUES (#{report_type},#{report_date},#{report_content},#{report_person_id},#{whether_dispose},#{other})")
    void add_report(@Param("report_type") String report_type, @Param("report_date") String report_date, @Param("report_content")
    String report_content, @Param("report_person_id") String report_person_id, @Param("whether_dispose") String whether_dispose, @Param("other") String other);

    @Update("UPDATE `reports` SET `whether_dispose`='已处理', `dispose_staff_id`=#{dispose_staff_id} ,`dispose_date`=#{dispose_date}  WHERE `id`=#{id}")
    void finish_report(@Param("dispose_staff_id") String dispose_staff_id,@Param("dispose_date") String dispose_date,@Param("id") int id);
}
