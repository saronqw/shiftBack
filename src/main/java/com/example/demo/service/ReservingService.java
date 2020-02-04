package com.example.demo.service;

import com.example.demo.entity.ReservEntity;
import com.example.demo.repository.IReservRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservingService implements IReservingService {

    @Autowired
    private IReservRepository reservRepository;

    @Override
    public ReservEntity add(ReservEntity reserv) {
        return reservRepository.save(reserv);
    }

    @Override
    public ReservEntity getAllReserved() {
        return null;
    }
}
