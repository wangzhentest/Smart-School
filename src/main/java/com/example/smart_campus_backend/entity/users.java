package com.example.smart_campus_backend.entity;

public class users {
    private int id;
    private String user_id;
    private String name;
    private int age;
    private String sex;
    private String phone;
    private String position;
    private int if_online;

    public users() {
    }

    public users(int id, String user_id, String name, int age, String sex, String phone, String position, int if_online) {
        this.id = id;
        this.user_id = user_id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.phone = phone;
        this.position = position;
        this.if_online = if_online;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIf_online() {
        return if_online;
    }

    public void setIf_online(int if_online) {
        this.if_online = if_online;
    }
}
