package com.example.smart_campus_backend.entity;

public class repairmen {
    private int id;
    private String repairman_id;
    private String repairman_name;
    private int repairman_age;
    private String repairman_sex;
    private String repairman_office;
    private String repairman_direction;
    private String repairman_phone;
    private int repairman_state;
    private String if_working;

    public repairmen() {
    }

    public repairmen(String repairman_id, String repairman_name, int repairman_age, String repairman_sex, String repairman_office, String repairman_direction, String repairman_phone, int repairman_state, String if_working) {
        this.repairman_id = repairman_id;
        this.repairman_name = repairman_name;
        this.repairman_age = repairman_age;
        this.repairman_sex = repairman_sex;
        this.repairman_office = repairman_office;
        this.repairman_direction = repairman_direction;
        this.repairman_phone = repairman_phone;
        this.repairman_state = repairman_state;
        this.if_working = if_working;
    }

    public repairmen(int id, String repairman_id, String repairman_name, int repairman_age, String repairman_sex, String repairman_office, String repairman_direction, String repairman_phone, int repairman_state, String if_working) {
        this.id = id;
        this.repairman_id = repairman_id;
        this.repairman_name = repairman_name;
        this.repairman_age = repairman_age;
        this.repairman_sex = repairman_sex;
        this.repairman_office = repairman_office;
        this.repairman_direction = repairman_direction;
        this.repairman_phone = repairman_phone;
        this.repairman_state = repairman_state;
        this.if_working = if_working;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRepairman_id() {
        return repairman_id;
    }

    public void setRepairman_id(String repairman_id) {
        this.repairman_id = repairman_id;
    }

    public String getRepairman_name() {
        return repairman_name;
    }

    public void setRepairman_name(String repairman_name) {
        this.repairman_name = repairman_name;
    }

    public int getRepairman_age() {
        return repairman_age;
    }

    public void setRepairman_age(int repairman_age) {
        this.repairman_age = repairman_age;
    }

    public String getRepairman_sex() {
        return repairman_sex;
    }

    public void setRepairman_sex(String repairman_sex) {
        this.repairman_sex = repairman_sex;
    }

    public String getRepairman_office() {
        return repairman_office;
    }

    public void setRepairman_office(String repairman_office) {
        this.repairman_office = repairman_office;
    }

    public String getRepairman_direction() {
        return repairman_direction;
    }

    public void setRepairman_direction(String repairman_direction) {
        this.repairman_direction = repairman_direction;
    }

    public String getRepairman_phone() {
        return repairman_phone;
    }

    public void setRepairman_phone(String repairman_phone) {
        this.repairman_phone = repairman_phone;
    }

    public int getRepairman_state() {
        return repairman_state;
    }

    public void setRepairman_state(int repairman_state) {
        this.repairman_state = repairman_state;
    }

    public String getIf_working() {
        return if_working;
    }

    public void setIf_working(String if_working) {
        this.if_working = if_working;
    }
}
