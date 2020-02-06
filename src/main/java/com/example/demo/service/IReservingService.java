package com.example.demo.service;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.model.api.ResultResponse;
import com.example.demo.model.api.request.AddReservationRequest;
import java.util.List;

/**
 * Интерфейс, определяющий функционал ReservingService:
 * добавление, получение.
 */
public interface IReservingService {
    ReservationEntity add(ReservationEntity reservationEntity);
    ResultResponse add_v2(AddReservationRequest addReservationRequest) throws Exception;
    ReservationEntity get(Long id);
    List<ReservationEntity> getByService(String service);
    List<String> getByDayAndService(String service, Long time);
}
