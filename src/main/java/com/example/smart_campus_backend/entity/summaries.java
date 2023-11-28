package com.example.smart_campus_backend.entity;

public class summaries {
    private int id;
    private int incident_id;
    private String incident_type;
    private String occur_date;
    private String occur_place;
    private String incident_reason;
    private String dispose_date;
    private String dispose_staff_id;
    private String expenditures;
    private String potential_risk;

    public summaries() {
    }

    public summaries(int id, int incident_id, String incident_type, String occur_date, String occur_place, String incident_reason, String dispose_date, String dispose_staff_id, String expenditures, String potential_risk) {
        this.id = id;
        this.incident_id = incident_id;
        this.incident_type = incident_type;
        this.occur_date = occur_date;
        this.occur_place = occur_place;
        this.incident_reason = incident_reason;
        this.dispose_date = dispose_date;
        this.dispose_staff_id = dispose_staff_id;
        this.expenditures = expenditures;
        this.potential_risk = potential_risk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIncident_id() {
        return incident_id;
    }

    public void setIncident_id(int incident_id) {
        this.incident_id = incident_id;
    }

    public String getIncident_type() {
        return incident_type;
    }

    public void setIncident_type(String incident_type) {
        this.incident_type = incident_type;
    }

    public String getOccur_date() {
        return occur_date;
    }

    public void setOccur_date(String occur_date) {
        this.occur_date = occur_date;
    }

    public String getOccur_place() {
        return occur_place;
    }

    public void setOccur_place(String occur_place) {
        this.occur_place = occur_place;
    }

    public String getIncident_reason() {
        return incident_reason;
    }

    public void setIncident_reason(String incident_reason) {
        this.incident_reason = incident_reason;
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

    public String getExpenditures() {
        return expenditures;
    }

    public void setExpenditures(String expenditures) {
        this.expenditures = expenditures;
    }

    public String getPotential_risk() {
        return potential_risk;
    }

    public void setPotential_risk(String potential_risk) {
        this.potential_risk = potential_risk;
    }
}
