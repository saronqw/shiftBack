package com.example.demo.repository;

import com.example.demo.entity.ReservEntity;
import org.springframework.data.repository.CrudRepository;

public interface IReservRepository extends CrudRepository<ReservEntity, Long> {
//    ReservEntity add(ReservEntity reserv);
//    ReservEntity getAllReserved();
}
