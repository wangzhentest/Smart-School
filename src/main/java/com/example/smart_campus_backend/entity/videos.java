package com.example.smart_campus_backend.entity;

public class videos {
    private int id;
    private String video_name;
    private String video_time;
    private String video_reason;
    private String video_camera;
    private String video_area;
    public videos() {
    }

    public videos(String video_name, String video_time, String video_reason, String video_camera, String video_area) {
        this.video_name = video_name;
        this.video_time = video_time;
        this.video_reason = video_reason;
        this.video_camera = video_camera;
        this.video_area = video_area;
    }

    public videos(int id, String video_name, String video_time, String video_reason, String video_camera, String video_area) {
        this.id = id;
        this.video_name = video_name;
        this.video_time = video_time;
        this.video_reason = video_reason;
        this.video_camera = video_camera;
        this.video_area = video_area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideo_name() {
        return video_name;
    }

    public void setVideo_name(String video_name) {
        this.video_name = video_name;
    }

    public String getVideo_time() {
        return video_time;
    }

    public void setVideo_time(String video_time) {
        this.video_time = video_time;
    }

    public String getVideo_reason() {
        return video_reason;
    }

    public void setVideo_reason(String video_reason) {
        this.video_reason = video_reason;
    }

    public String getVideo_camera() {
        return video_camera;
    }

    public void setVideo_camera(String video_camera) {
        this.video_camera = video_camera;
    }

    public String getVideo_area() {
        return video_area;
    }

    public void setVideo_area(String video_area) {
        this.video_area = video_area;
    }
}
