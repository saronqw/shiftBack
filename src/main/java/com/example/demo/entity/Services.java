package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Services {
    private List<Service> services;

    public Services() {
        services = new ArrayList<>();
    }

    public List<Service> getBarList() {
        services.add(new Service("Hookah", "Кальян"));
        services.add(new Service("XBox", ""));
        services.add(new Service("Billiards", "Билльярд"));
        services.add(new Service("Bowling", "Боулинг"));
        services.add(new Service("Darts", "Дартс"));
        services.add(new Service("Karaoke", "Караоке"));
        return services;
    }
}
