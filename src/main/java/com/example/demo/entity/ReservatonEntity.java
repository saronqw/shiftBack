package com.example.demo.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "reserv")
public class ReservatonEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "service")
    private String service;

    @OneToOne(cascade = CascadeType.ALL)
    private DateTimeEntity dateTime;

    @Column(name = "student_document")
    private Long studentDocument;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Long getStudentDocument() { return studentDocument; }

    public void setStudentDocument(Long studentDocument) { this.studentDocument = studentDocument; }

    public DateTimeEntity getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTimeEntity dateTime) {
        this.dateTime = dateTime;
    }
}
