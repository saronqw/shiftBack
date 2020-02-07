package com.example.demo.exception;


public class RecordExistException extends RuntimeException {
    private Object object;

    public RecordExistException(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
