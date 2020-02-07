package com.example.demo.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Сущность, содержащая информацию о брони.
 * service - название сервиса;
 * dateTime - объект времени;
 * studentDocument - номер студака.
 */
@Entity
@Table(name = "reserv")
public class ReservationEntity {

    public ReservationEntity() { }

    public ReservationEntity(String service, DateTimeEntity dateTime, Long studentDocument) {
        this.service = service;
        this.dateTime = dateTime;
        this.studentDocument = studentDocument;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "service")
    private String service;

    /**
     * Связь один к одному с сущностью, содержащей дату и время.
     */
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
