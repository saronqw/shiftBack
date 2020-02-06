package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, добавляющий (содержащий) списки услуг (сервисов).
 */
public class Services {
    private List<Service> services;

    public Services() {
        services = new ArrayList<>();
    }

    /**
     * Списки сервисов бара
     * @return
     */
    public List<Service> getBarList() {
        services.add(new Service("Hookah", "Кальян"));
        services.add(new Service("PS/XBox", "PS/XBOX"));
        services.add(new Service("Billiards", "Билльярд"));
        services.add(new Service("Bowling", "Боулинг"));
        services.add(new Service("Darts", "Дартц"));
        services.add(new Service("Karaoke", "Караоке"));

        return services;
    }

    /**
     * Списки сервисов бассейна
     * @return
     */
    public List<Service> getPoolList() {
        services.add(new Service("Swimming Circle", "Плавательный Круг"));
        services.add(new Service("Trainer", "Дорожка с трененром"));
        services.add(new Service("Sheislong", "Шезлонг"));
        services.add(new Service("Children Track", "Детская дорожка"));
        services.add(new Service("Adult Track", "Взрослая дорожка"));

        return services;
    }

    /**
     * Списки сервисов спа
     * @return
     */
    public List<Service> getSPAList() {
        services.add(new Service("Massage", "Массаж"));
        services.add(new Service("Sauna", "Сауна"));
        services.add(new Service("Acupuncture", "Иглоукалывание"));
        services.add(new Service("Manicure", "Маникюр"));
        services.add(new Service("Pedicure", "Педикюр"));

        return services;
    }

    /**
     * Списки сервисов спортзала
     * @return
     */
    public List<Service> getSportList() {
        services.add(new Service("Gym", "Качалка"));
        services.add(new Service("Cardio", "Беговая дорожка/Кардио"));
        services.add(new Service("Bars", "Брусья"));
        services.add(new Service("Yoga", "Йога-зал"));
        services.add(new Service("MMA", "Ринг/MMA зал"));

        return services;
    }
}
