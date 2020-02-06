package com.example.demo.exception;

public class NullFieldsException extends RuntimeException {
    private Object object;

    public NullFieldsException(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
