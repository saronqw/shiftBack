package com.example.demo.repository;

import com.example.demo.entity.ReservatonEntity;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Max;
import java.util.List;

public interface IReservRepository extends CrudRepository<ReservatonEntity, Long> {
//    ReservEntity add(ReservEntity reserv);
//    ReservEntity getAllReserved();
     List<ReservatonEntity> findByService(String service);
}
