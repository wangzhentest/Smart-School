package com.example.smart_campus_backend.entity;

public class medical_staffs {
    private int id;
    private String medical_staff_id;
    private String medical_staff_name;
    private int medical_staff_age;
    private String medical_staff_sex;
    private String medical_staff_rank;
    private String medical_staff_office;
    private String medical_staff_phone;
    private int medical_staff_state;
    private String if_working;

    public medical_staffs() {
    }

    public medical_staffs(String medical_staff_id, String medical_staff_name, int medical_staff_age, String medical_staff_sex, String medical_staff_rank, String medical_staff_office, String medical_staff_phone, int medical_staff_state, String if_working) {
        this.medical_staff_id = medical_staff_id;
        this.medical_staff_name = medical_staff_name;
        this.medical_staff_age = medical_staff_age;
        this.medical_staff_sex = medical_staff_sex;
        this.medical_staff_rank = medical_staff_rank;
        this.medical_staff_office = medical_staff_office;
        this.medical_staff_phone = medical_staff_phone;
        this.medical_staff_state = medical_staff_state;
        this.if_working = if_working;
    }

    public medical_staffs(int id, String medical_staff_id, String medical_staff_name, int medical_staff_age, String medical_staff_sex, String medical_staff_rank, String medical_staff_office, String medical_staff_phone, int medical_staff_state, String if_working) {
        this.id = id;
        this.medical_staff_id = medical_staff_id;
        this.medical_staff_name = medical_staff_name;
        this.medical_staff_age = medical_staff_age;
        this.medical_staff_sex = medical_staff_sex;
        this.medical_staff_rank = medical_staff_rank;
        this.medical_staff_office = medical_staff_office;
        this.medical_staff_phone = medical_staff_phone;
        this.medical_staff_state = medical_staff_state;
        this.if_working = if_working;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedical_staff_id() {
        return medical_staff_id;
    }

    public void setMedical_staff_id(String medical_staff_id) {
        this.medical_staff_id = medical_staff_id;
    }

    public String getMedical_staff_name() {
        return medical_staff_name;
    }

    public void setMedical_staff_name(String medical_staff_name) {
        this.medical_staff_name = medical_staff_name;
    }

    public int getMedical_staff_age() {
        return medical_staff_age;
    }

    public void setMedical_staff_age(int medical_staff_age) {
        this.medical_staff_age = medical_staff_age;
    }

    public String getMedical_staff_sex() {
        return medical_staff_sex;
    }

    public void setMedical_staff_sex(String medical_staff_sex) {
        this.medical_staff_sex = medical_staff_sex;
    }

    public String getMedical_staff_rank() {
        return medical_staff_rank;
    }

    public void setMedical_staff_rank(String medical_staff_rank) {
        this.medical_staff_rank = medical_staff_rank;
    }

    public String getMedical_staff_office() {
        return medical_staff_office;
    }

    public void setMedical_staff_office(String medical_staff_office) {
        this.medical_staff_office = medical_staff_office;
    }

    public String getMedical_staff_phone() {
        return medical_staff_phone;
    }

    public void setMedical_staff_phone(String medical_staff_phone) {
        this.medical_staff_phone = medical_staff_phone;
    }

    public int getMedical_staff_state() {
        return medical_staff_state;
    }

    public void setMedical_staff_state(int medical_staff_state) {
        this.medical_staff_state = medical_staff_state;
    }

    public String getIf_working() {
        return if_working;
    }

    public void setIf_working(String if_working) {
        this.if_working = if_working;
    }
}
