package com.example.demo.service;

import com.example.demo.entity.ReservationEntity;

import java.util.List;

public interface IReservingService {
    ReservationEntity add(ReservationEntity reservationEntity);
    ReservationEntity get(Long id);
    List<ReservationEntity> getByService(String service);
    List<String> getByDayAndService(String service, Long time);
}
