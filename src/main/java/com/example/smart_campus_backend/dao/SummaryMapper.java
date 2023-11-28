package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.summaries;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface SummaryMapper {
    @Select("select * from `smart_campus`.`summaries`")
    List<summaries> get_summaries();

    @Select("select * from `smart_campus`.`summaries` where incident_id = #{incident_id}")
    summaries get_summary(@Param("incident_id") int incident_id);

    @Select("select * from `smart_campus`.`summaries` where incident_id = #{incident_id}")
    summaries get_summary_by_id(@Param("incident_id") int incident_id);

    @Insert("INSERT INTO `summaries` (`incident_id`, `incident_type`, `occur_date`, `occur_place`, `incident_reason`, `dispose_date`, `dispose_staff_id`, `expenditures`, `potential_risk`) VALUES " +
            "(#{incident_id},#{incident_type},#{occur_date},#{occur_place},#{incident_reason},#{dispose_date},#{dispose_staff_id},#{expenditures},#{potential_risk})")
    void add_summary(@Param("incident_id") int incident_id,@Param("incident_type") String incident_type,@Param("occur_date") String occur_date,@Param("occur_place") String occur_place,
    @Param("incident_reason") String incident_reason,@Param("dispose_date") String dispose_date,@Param("dispose_staff_id") String dispose_staff_id,@Param("expenditures") String expenditures,@Param("potential_risk") String potential_risk);

}
