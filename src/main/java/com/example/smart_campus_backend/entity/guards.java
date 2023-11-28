package com.example.smart_campus_backend.entity;

public class guards {
    private int id;
    private String guard_id;
    private String guard_name;
    private int guard_age;
    private String guard_sex;
    private String guard_rank;
    private String guard_office;
    private String guard_position;
    private String guard_phone;
    private int guard_state;
    private String if_working;

    public guards() {
    }

    public guards(String guard_id, String guard_name, int guard_age, String guard_sex, String guard_rank, String guard_office, String guard_position, String guard_phone, int guard_state, String if_working) {
        this.guard_id = guard_id;
        this.guard_name = guard_name;
        this.guard_age = guard_age;
        this.guard_sex = guard_sex;
        this.guard_rank = guard_rank;
        this.guard_office = guard_office;
        this.guard_position = guard_position;
        this.guard_phone = guard_phone;
        this.guard_state = guard_state;
        this.if_working = if_working;
    }

    public guards(int id, String guard_id, String guard_name, int guard_age, String guard_sex, String guard_rank, String guard_office, String guard_position, String guard_phone, int guard_state, String if_working) {
        this.id = id;
        this.guard_id = guard_id;
        this.guard_name = guard_name;
        this.guard_age = guard_age;
        this.guard_sex = guard_sex;
        this.guard_rank = guard_rank;
        this.guard_office = guard_office;
        this.guard_position = guard_position;
        this.guard_phone = guard_phone;
        this.guard_state = guard_state;
        this.if_working = if_working;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGuard_id() {
        return guard_id;
    }

    public void setGuard_id(String guard_id) {
        this.guard_id = guard_id;
    }

    public String getGuard_name() {
        return guard_name;
    }

    public void setGuard_name(String guard_name) {
        this.guard_name = guard_name;
    }

    public int getGuard_age() {
        return guard_age;
    }

    public void setGuard_age(int guard_age) {
        this.guard_age = guard_age;
    }

    public String getGuard_sex() {
        return guard_sex;
    }

    public void setGuard_sex(String guard_sex) {
        this.guard_sex = guard_sex;
    }

    public String getGuard_rank() {
        return guard_rank;
    }

    public void setGuard_rank(String guard_rank) {
        this.guard_rank = guard_rank;
    }

    public String getGuard_office() {
        return guard_office;
    }

    public void setGuard_office(String guard_office) {
        this.guard_office = guard_office;
    }

    public String getGuard_position() {
        return guard_position;
    }

    public void setGuard_position(String guard_position) {
        this.guard_position = guard_position;
    }

    public String getGuard_phone() {
        return guard_phone;
    }

    public void setGuard_phone(String guard_phone) {
        this.guard_phone = guard_phone;
    }

    public int getGuard_state() {
        return guard_state;
    }

    public void setGuard_state(int guard_state) {
        this.guard_state = guard_state;
    }

    public String getIf_working() {
        return if_working;
    }

    public void setIf_working(String if_working) {
        this.if_working = if_working;
    }
}
