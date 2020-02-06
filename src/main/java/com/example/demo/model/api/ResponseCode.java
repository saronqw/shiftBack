package com.example.demo.model.api;

public enum ResponseCode {
    OK("OK"),
    ERROR("ERROR");

    private String code;

    ResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
