package com.example.demo.service;

import com.example.demo.entity.ReservatonEntity;

import java.util.List;

public interface IReservingService {
    ReservatonEntity add(ReservatonEntity reserv);
    ReservatonEntity getAllReserved();
    ReservatonEntity get(Long id);
    List<ReservatonEntity> getByService(String service);
}
