package com.example.demo.exception;


/**
 * Класс обработчик исключений, возникающих в случае
 * попытки сделать запись на занятое время.
 */
public class RecordExistException extends RuntimeException {
    private Object object;

    public RecordExistException(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }
}
