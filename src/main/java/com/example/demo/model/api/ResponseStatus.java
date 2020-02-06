package com.example.demo.model.api;

/**
 * Класс, хранящий код ошибки и сообщение ошибки.
 */
public class ResponseStatus {
    private String code;
    private String errorMessage;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
