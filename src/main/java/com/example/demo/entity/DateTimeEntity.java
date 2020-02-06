package com.example.demo.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * date - Дата в формате 1523232000000
 * time - Время в формате 12:00
 */
@Entity
@Table(name = "date_time")
public class DateTimeEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "date")
    private Long date;

    @Column(name = "time")
    private String time;

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
