package com.example.demo.exception;

import com.example.demo.model.api.request.AddReservationRequest;

public class RecordExistException extends RuntimeException {

    private AddReservationRequest addReservationRequest = new AddReservationRequest();

    public RecordExistException(AddReservationRequest addReservationRequest) {
        this.addReservationRequest.setService(addReservationRequest.getService());
        this.addReservationRequest.setDateTime(addReservationRequest.getDateTime());
        this.addReservationRequest.setStudentDocument(addReservationRequest.getStudentDocument());
    }

    public AddReservationRequest getAddReservationRequest() {
        return addReservationRequest;
    }
}
