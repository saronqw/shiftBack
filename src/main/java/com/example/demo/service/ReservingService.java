package com.example.demo.service;

import com.example.demo.entity.ReservatonEntity;
import com.example.demo.repository.IReservRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservingService implements IReservingService {

    @Autowired
    private IReservRepository reservRepository;

    @Override
    public ReservatonEntity add(ReservatonEntity reserv) {
        return reservRepository.save(reserv);
    }

    @Override
    public ReservatonEntity getAllReserved() {
        return null;
    }

    @Override
    public ReservatonEntity get(Long id) {
        return reservRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservatonEntity> getByService(String service) {
        return reservRepository.findByService(service);
    }
}
