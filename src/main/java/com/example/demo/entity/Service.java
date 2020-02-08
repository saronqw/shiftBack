package com.example.demo.entity;

/**
 * Класс, необходимый, чтобы передать объект в двух языках.
 */
public class Service {
    private String eng;
    private String rus;

    public Service(String eng, String rus) {
        this.eng = eng;
        this.rus = rus;
    }

    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getRus() {
        return rus;
    }

    public void setRus(String rus) {
        this.rus = rus;
    }
}
