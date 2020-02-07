package com.example.demo.service;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.model.api.ResponseCode;
import com.example.demo.model.api.ResponseStatus;
import com.example.demo.model.api.ResultResponse;
import com.example.demo.model.api.request.AddReservationRequest;
import com.example.demo.model.api.response.AddReservationResponse;
import com.example.demo.repository.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс сервиса, оперирующий с репозиторием (сохраняет в БД).
 */
@Service
public class ReservingService implements IReservingService {

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public ReservationEntity add(ReservationEntity reservationEntity) {
        return reservationRepository.save(reservationEntity);
    }

    /**
     * Метод, добавляющий запись и возвращающий статус операции.
     * @param addReservationRequest
     * @return Возвращает объект класса ResultResponse
     */
    @Override
    public ResultResponse add_v2(AddReservationRequest addReservationRequest) {
        ReservationEntity reservationEntity = new ReservationEntity(
                addReservationRequest.getService(),
                addReservationRequest.getDateTime(),
                addReservationRequest.getStudentDocument()
        );
        reservationRepository.save(reservationEntity);

        AddReservationResponse addReservationResponse = createAddReservationResponse(reservationEntity);
        ResultResponse resultResponse = new ResultResponse();
        ResponseStatus status = new ResponseStatus();
        status.setCode(ResponseCode.OK.getCode());
        resultResponse.setStatus(status);
        resultResponse.setData(addReservationResponse);
        return resultResponse;
    }

    /**
     * Метод создания объекта класса AddReservationResponse,
     * используемый в {@link #add_v2(AddReservationRequest)}
     * @param reservationEntity
     * @return Возвращает объект класса AddReservationResponse.
     */
    private AddReservationResponse createAddReservationResponse(ReservationEntity reservationEntity) {
        AddReservationResponse addReservationResponse = new AddReservationResponse();
        addReservationResponse.setService(reservationEntity.getService());
        addReservationResponse.setDateTime(reservationEntity.getDateTime());
        addReservationResponse.setStudentDocument(reservationEntity.getStudentDocument());
        return addReservationResponse;
    }

    @Override
    public ReservationEntity get(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<ReservationEntity> getByService(String service) {
        return reservationRepository.findByService(service);
    }

    /**
     * Метод для получения списка времен для сервиса в определенную дату.
     * @param service
     * @param date
     * @return Возвращает список времен.
     */
    @Override
    public List<String> getByDayAndService(String service, Long date) {
        List<String> times = new ArrayList<>();

        for (ReservationEntity rep: reservationRepository
                .findByServiceAndDateTime_Date(service, date)) {
            times.add(rep.getDateTime().getTime());
        }
        times.sort(String::compareToIgnoreCase);

        return times;
    }

    @Override
    public ResultResponse getByDayAndService_v2(String service, Long date) {
        List<String> times = new ArrayList<>();

        for (ReservationEntity rep: reservationRepository
                .findByServiceAndDateTime_Date(service, date)) {
            times.add(rep.getDateTime().getTime());
        }
        times.sort(String::compareToIgnoreCase);

        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setData(times);

        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseCode.OK.getCode());
        resultResponse.setStatus(responseStatus);

        return resultResponse;
    }
}
