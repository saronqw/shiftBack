package com.example.demo.model.api.request;

import com.example.demo.entity.DateTimeEntity;

/**
 * Класс, возвращающий запись.
 */
public class AddReservationRequest {

    private String service;

    private DateTimeEntity dateTime;

    private Long studentDocument;


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
