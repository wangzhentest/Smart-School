package com.example.smart_campus_backend.entity;

public class incidents {
    private int id;
    private int incident_id;
    private String incident_type;
    private String incident_date;
    private String incident_position;
    private String camera_id;
    private String if_handle;
    private String handle_date;
    private String handle_staff_id;
    private String video;
    private String other;

    public incidents() {
    }

    public incidents(int id, int incident_id, String incident_type, String incident_date, String incident_position, String camera_id, String if_handle, String handle_date, String handle_staff_id, String video, String other) {
        this.id = id;
        this.incident_id = incident_id;
        this.incident_type = incident_type;
        this.incident_date = incident_date;
        this.incident_position = incident_position;
        this.camera_id = camera_id;
        this.if_handle = if_handle;
        this.handle_date = handle_date;
        this.handle_staff_id = handle_staff_id;
        this.video = video;
        this.other = other;
    }

    public int getIncident_id() {
        return incident_id;
    }

    public void setIncident_id(int incident_id) {
        this.incident_id = incident_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(String incident_type) {
        this.incident_type = incident_type;
    }

    public String getIncident_date() {
        return incident_date;
    }

    public void setIncident_date(String incident_date) {
        this.incident_date = incident_date;
    }

    public String getIncident_position() {
        return incident_position;
    }

    public void setIncident_position(String incident_position) {
        this.incident_position = incident_position;
    }

    public String getCamera_id() {
        return camera_id;
    }

    public void setCamera_id(String camera_id) {
        this.camera_id = camera_id;
    }

    public String getIf_handle() {
        return if_handle;
    }

    public void setIf_handle(String if_handle) {
        this.if_handle = if_handle;
    }

    public String getHandle_date() {
        return handle_date;
    }

    public void setHandle_date(String handle_date) {
        this.handle_date = handle_date;
    }

    public String getHandle_staff_id() {
        return handle_staff_id;
    }

    public void setHandle_staff_id(String handle_staff_id) {
        this.handle_staff_id = handle_staff_id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
