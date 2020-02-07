package com.example.demo.exception;


public class RecordExistException extends RuntimeException {

    //private AddReservationRequest addReservationRequest = new AddReservationRequest();
    private Object object;

    /*public RecordExistException(AddReservationRequest addReservationRequest) {
        this.addReservationRequest.setService(addReservationRequest.getService());
        this.addReservationRequest.setDateTime(addReservationRequest.getDateTime());
        this.addReservationRequest.setStudentDocument(addReservationRequest.getStudentDocument());
    }

    public AddReservationRequest getAddReservationRequest() {
        return addReservationRequest;
    }*/

    public RecordExistException(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
