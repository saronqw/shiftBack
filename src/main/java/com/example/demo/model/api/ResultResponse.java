package com.example.demo.model.api;

/**
 * Класс, хранящий результат операции и его статус.
 */
public class ResultResponse {
    private ResponseStatus status;
    private Object data;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
