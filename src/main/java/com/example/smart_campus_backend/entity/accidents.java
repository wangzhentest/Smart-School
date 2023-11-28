package com.example.smart_campus_backend.entity;

public class accidents {
    private int id;
    private int incident_id;
    private String accident_type;
    private String accident_date;
    private String accident_reason;
    private String dispose_date;
    private String dispose_staff_id;
    private String other;

    public accidents() {
    }

    public accidents(int id, int incident_id, String accident_type, String accident_date, String accident_reason, String dispose_date, String dispose_staff_id, String other) {
        this.id = id;
        this.incident_id = incident_id;
        this.accident_type = accident_type;
        this.accident_date = accident_date;
        this.accident_reason = accident_reason;
        this.dispose_date = dispose_date;
        this.dispose_staff_id = dispose_staff_id;
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

    public String getAccident_type() {
        return accident_type;
    }

    public void setAccident_type(String accident_type) {
        this.accident_type = accident_type;
    }

    public String getAccident_date() {
        return accident_date;
    }

    public void setAccident_date(String accident_date) {
        this.accident_date = accident_date;
    }

    public String getAccident_reason() {
        return accident_reason;
    }

    public void setAccident_reason(String accident_reason) {
        this.accident_reason = accident_reason;
    }

    public String getDispose_date() {
        return dispose_date;
    }

    public void setDispose_date(String dispose_date) {
        this.dispose_date = dispose_date;
    }

    public String getDispose_staff_id() {
        return dispose_staff_id;
    }

    public void setDispose_staff_id(String dispose_staff_id) {
        this.dispose_staff_id = dispose_staff_id;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}
