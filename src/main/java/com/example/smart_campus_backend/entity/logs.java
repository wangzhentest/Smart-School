package com.example.smart_campus_backend.entity;

public class logs {
    private int id;
    private String change_type;
    private int change_id;
    private String change_date;
    private String user_id;
    private String operate;

    public logs() {
    }

    public logs(String change_type, int change_id, String change_date, String user_id, String operate) {
        this.change_type = change_type;
        this.change_id = change_id;
        this.change_date = change_date;
        this.user_id = user_id;
        this.operate = operate;
    }

    public logs(int id, String change_type, int change_id, String change_date, String user_id, String operate) {
        this.id = id;
        this.change_type = change_type;
        this.change_id = change_id;
        this.change_date = change_date;
        this.user_id = user_id;
        this.operate = operate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChange_type() {
        return change_type;
    }

    public void setChange_type(String change_type) {
        this.change_type = change_type;
    }

    public int getChange_id() {
        return change_id;
    }

    public void setChange_id(int change_id) {
        this.change_id = change_id;
    }

    public String getChange_date() {
        return change_date;
    }

    public void setChange_date(String change_date) {
        this.change_date = change_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }
}
