package com.example.smart_campus_backend.dao;


import com.example.smart_campus_backend.entity.accounts;
import com.example.smart_campus_backend.entity.messages;
import com.example.smart_campus_backend.entity.users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
@Repository

public interface UserMapper { ;

    @Select("select * from `smart_campus`.`users` where user_id=#{user_id}")
    users getUser(@Param("user_id") String user_id);
    //获取所有用户
    @Select("select * from `smart_campus`.`users`")
    List<users> get_users();

    //用户上线
    @Update("UPDATE `users` SET `if_online`=1 WHERE `user_id`=#{user_id};")
    void go_online(@Param("user_id") String user_id);

    //用户下线
    @Update("UPDATE `users` SET `if_online`=0 WHERE `user_id`=#{user_id};")
    void down_online(@Param("user_id") String user_id);

    @Select("select pwd from `smart_campus`.`accounts` where user_id=#{user_id}")
    String get_pwd(@Param("user_id") String user_id);
}
