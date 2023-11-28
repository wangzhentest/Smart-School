package com.example.smart_campus_backend.entity;

public class cameras {
    private int id;
    private String camera_id;
    private String camera_position;
    private String camera_source;
    private int camera_state;


    public cameras() {
    }

    public cameras(String camera_id, String camera_position, String camera_source, int camera_state) {
        this.camera_id = camera_id;
        this.camera_position = camera_position;
        this.camera_source = camera_source;
        this.camera_state = camera_state;
    }

    public cameras(int id, String camera_id, String camera_position, String camera_source, int camera_state) {
        this.id = id;
        this.camera_id = camera_id;
        this.camera_position = camera_position;
        this.camera_source = camera_source;
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

    public String getCamera_position() {
        return camera_position;
    }

    public void setCamera_position(String camera_position) {
        this.camera_position = camera_position;
    }

    public int getCamera_state() {
        return camera_state;
    }

    public String getCamera_source() {
        return camera_source;
    }

    public void setCamera_source(String camera_source) {
        this.camera_source = camera_source;
    }

    public void setCamera_state(int camera_state) {
        this.camera_state = camera_state;
    }
}
