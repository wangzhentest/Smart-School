package com.example.smart_campus_backend.entity;

public class camera_list {
    private int id;
    private String camera_id;
    private String camera_area;
    private String camera_position;
    private String camera_source;
    private int fixer_id;
    private String fixer_name;
    private int fixer_telephone;
    private int camera_state;

    public camera_list() {
    }

    public camera_list(int id, String camera_id, String camera_area, String camera_position, String camera_source, int fixer_id, String fixer_name, int fixer_telephone, int camera_state) {
        this.id = id;
        this.camera_id = camera_id;
        this.camera_area = camera_area;
        this.camera_position = camera_position;
        this.camera_source = camera_source;
        this.fixer_id = fixer_id;
        this.fixer_name = fixer_name;
        this.fixer_telephone = fixer_telephone;
        this.camera_state = camera_state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(String camera_id) {
        this.camera_id = camera_id;
    }

    public String getCamera_area() {
        return camera_area;
    }

    public void setCamera_area(String camera_area) {
        this.camera_area = camera_area;
    }

    public String getCamera_position() {
        return camera_position;
    }

    public void setCamera_position(String camera_position) {
        this.camera_position = camera_position;
    }

    public String getCamera_source() {
        return camera_source;
    }

    public void setCamera_source(String camera_source) {
        this.camera_source = camera_source;
    }

    public int getFixer_id() {
        return fixer_id;
    }

    public void setFixer_id(int fixer_id) {
        this.fixer_id = fixer_id;
    }

    public String getFixer_name() {
        return fixer_name;
    }

    public void setFixer_name(String fixer_name) {
        this.fixer_name = fixer_name;
    }

    public int getFixer_telephone() {
        return fixer_telephone;
    }

    public void setFixer_telephone(int fixer_telephone) {
        this.fixer_telephone = fixer_telephone;
    }

    public int getCamera_state() {
        return camera_state;
    }

    public void setCamera_state(int camera_state) {
        this.camera_state = camera_state;
    }
}
