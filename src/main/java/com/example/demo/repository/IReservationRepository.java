package com.example.demo.repository;

import com.example.demo.entity.ReservatonEntity;
import org.springframework.data.repository.CrudRepository;

import javax.validation.constraints.Max;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface IReservationRepository extends CrudRepository<ReservatonEntity, Long> {
//    ReservEntity add(ReservEntity reserv);
//    ReservEntity getAllReserved();
     List<ReservatonEntity> findByService(String service);
     ReservatonEntity findByServiceAndDate(String service, Date date);
     ReservatonEntity findByServiceAndDateAndHour(String service, Timestamp date, String hour);
}
