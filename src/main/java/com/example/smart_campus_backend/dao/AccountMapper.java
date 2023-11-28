package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.accounts;
import com.example.smart_campus_backend.entity.messages;
import com.example.smart_campus_backend.entity.users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface AccountMapper {

    @Select("select * from `smart_campus`.`accounts` where account=#{account} and pwd = #{pwd}")
    accounts Login(@Param("account") String account,@Param("pwd") String pwd);

    @Select("select * from `smart_campus`.`messages`")
    List<messages> get_messages();

    @Select("select * from `smart_campus`.`users` where user_id=#{user_id}")
    users getUser(@Param("user_id") String user_id);

}
