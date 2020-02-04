package com.example.demo.service;

import com.example.demo.entity.ReservEntity;

public interface IReservingService {
    ReservEntity add(ReservEntity reserv);
    ReservEntity getAllReserved(); // Надо всё или по конкретным секциям?
}
