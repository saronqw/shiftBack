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
     * Списки сервисов бара.
     * @return Возвращает список сервисов бара.
     */
    public List<Service> getBarList() {
        services.add(new Service("hookah", "Кальян"));
        services.add(new Service("ps_xbox", "PS/XBOX"));
        services.add(new Service("billiards", "Билльярд"));
        services.add(new Service("bowling", "Боулинг"));
        services.add(new Service("darts", "Дартц"));
        services.add(new Service("karaoke", "Караоке"));

        return services;
    }

    /**
     * Списки сервисов бассейна.
     * @return Возвращает список сервисов бассейна.
     */
    public List<Service> getPoolList() {
        services.add(new Service("swimming_circle", "Плавательный Круг"));
        services.add(new Service("trainer", "Дорожка с трененром"));
        services.add(new Service("sheislong", "Шезлонг"));
        services.add(new Service("children_track", "Детская дорожка"));
        services.add(new Service("adult_track", "Взрослая дорожка"));

        return services;
    }

    /**
     * Списки сервисов спа.
     * @return Возвращает список сервисов спа.
     */
    public List<Service> getSPAList() {
        services.add(new Service("massage", "Массаж"));
        services.add(new Service("sauna", "Сауна"));
        services.add(new Service("acupuncture", "Иглоукалывание"));
        services.add(new Service("manicure", "Маникюр"));
        services.add(new Service("pedicure", "Педикюр"));

        return services;
    }

    /**
     * Списки сервисов спортзала.
     * @return Возвращает список сервисов спортзала.
     */
    public List<Service> getSportList() {
        services.add(new Service("gym", "Качалка"));
        services.add(new Service("cardio", "Беговая дорожка/Кардио"));
        services.add(new Service("ars", "Брусья"));
        services.add(new Service("yoga", "Йога-зал"));
        services.add(new Service("mma", "Ринг/MMA зал"));

        return services;
    }
}
