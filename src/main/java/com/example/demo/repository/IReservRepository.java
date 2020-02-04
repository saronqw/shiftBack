package com.example.demo.repository;

import com.example.demo.entity.ReservEntity;

public interface IReservRepository {
    ReservEntity add(ReservEntity reserv);
    ReservEntity getAllReserved();
}
