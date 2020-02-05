package com.example.demo.service;

import com.example.demo.entity.ReservatonEntity;
import com.example.demo.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class ReservingService implements IReservingService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public ReservatonEntity add(ReservatonEntity reservatonEntity) {
        return reservationRepository.save(reservatonEntity);
    }

    @Override
    public ReservatonEntity get(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservatonEntity> getByService(String service) {
        return reservationRepository.findByService(service);
    }
}
