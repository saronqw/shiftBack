package com.example.demo.repository;

import com.example.demo.entity.ReservationEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IReservationRepository extends CrudRepository<ReservationEntity, Long> {
     List<ReservationEntity> findByService(String service);
     List<ReservationEntity> findByServiceAndDateTime_Date(String service, Long date);
}
