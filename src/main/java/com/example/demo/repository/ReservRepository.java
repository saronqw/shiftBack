package com.example.demo.repository;

import com.example.demo.entity.ReservEntity;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReservRepository implements IReservRepository {
    private final AtomicLong id = new AtomicLong();
    private final Map<Long, ReservEntity> storage = new HashMap<>();

    @Override
    public ReservEntity add(ReservEntity reserv) {
        reserv.setId(id.incrementAndGet());
        storage.put(reserv.getId(), reserv);
        return reserv;
    }

    @Override
    public ReservEntity getAllReserved() {
        //return storage.get();
        return null;
    }

    /*@Override
    public ReservEntity get(Long id) {
        return storage.get(id);
    }*/
}