package com.example.demo.entity;

import java.sql.Timestamp;

public class DateTimeEntity {
    private Timestamp time;
    private String hour;

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
