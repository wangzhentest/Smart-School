package com.example.smart_campus_backend.entity;

public class accounts {
    private int id;
    private String user_id;
    private String account;
    private String pwd;

    public accounts() {
    }

    public accounts(int id, String user_id, String account, String pwd) {
        this.id = id;
        this.user_id = user_id;
        this.account = account;
        this.pwd = pwd;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
