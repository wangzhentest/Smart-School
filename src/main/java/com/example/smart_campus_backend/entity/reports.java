package com.example.smart_campus_backend.entity;

public class reports {
    private int id;
    private String report_type;
    private String report_date;
    private String report_content;
    private String report_person_id;
    private String whether_dispose;
    private String dispose_staff_id;
    private String dispose_date;
    private String other;

    public reports() {
    }

    public reports(String report_type, String report_date, String report_content, String report_person_id, String whether_dispose, String other) {
        this.report_type = report_type;
        this.report_date = report_date;
        this.report_content = report_content;
        this.report_person_id = report_person_id;
        this.whether_dispose = whether_dispose;
        this.other = other;
    }

    public reports(int id, String report_type, String report_date, String report_content, String report_person_id, String whether_dispose, String dispose_staff_id, String dispose_date, String other) {
        this.id = id;
        this.report_type = report_type;
        this.report_date = report_date;
        this.report_content = report_content;
        this.report_person_id = report_person_id;
        this.whether_dispose = whether_dispose;
        this.dispose_staff_id = dispose_staff_id;
        this.dispose_date = dispose_date;
        this.other = other;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReport_type() {
        return report_type;
    }

    public void setReport_type(String report_type) {
        this.report_type = report_type;
    }

    public String getReport_date() {
        return report_date;
    }

    public void setReport_date(String report_date) {
        this.report_date = report_date;
    }

    public String getReport_content() {
        return report_content;
    }

    public void setReport_content(String report_content) {
        this.report_content = report_content;
    }

    public String getReport_person_id() {
        return report_person_id;
    }

    public void setReport_person_id(String report_person_id) {
        this.report_person_id = report_person_id;
    }

    public String getWhether_dispose() {
        return whether_dispose;
    }

    public void setWhether_dispose(String whether_dispose) {
        this.whether_dispose = whether_dispose;
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
