package com.example.demo.service;

import com.example.demo.controller.TimetableController;
import com.example.demo.entity.ReservationEntity;
import com.example.demo.model.api.ResponseCode;
import com.example.demo.model.api.ResponseStatus;
import com.example.demo.model.api.ResultResponse;
import com.example.demo.model.api.request.AddReservationRequest;
import com.example.demo.model.api.response.AddReservationResponse;
import com.example.demo.repository.IReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Класс сервиса, оперирующий с репозиторием (сохраняет в БД).
 */
@Service
public class ReservingService implements IReservingService {
    Logger logger = LoggerFactory.getLogger(TimetableController.class);

    @Autowired
    private IReservationRepository reservationRepository;

    @Override
    public ReservationEntity add(ReservationEntity reservationEntity) {
        return reservationRepository.save(reservationEntity);
    }

    /**
     * Метод, добавляющий запись и возвращающий статус операции.
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
     * @param service Сервис, для которого необходимо получить список времен.
     * @param date Дата, для которой необходимо получчить список времен.
     * @return Возвращает список времен.
     * @deprecated V1 - Не предусмотрена проверка исключений.
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

    /**
     * Метод для получения списка времен для сервиса в определенную дату.
     * (предусмотрена проверка исключений)
     * @param service Сервис, для которого необходимо получить список времен.
     * @param date Дата, для которой необходимо получчить список времен.
     * @return Возвращает список времен.
     */
    @Override
    public ResultResponse getByDayAndService_v2(String service, Long date) {
        List<String> times = new ArrayList<>();

        for (ReservationEntity rep : reservationRepository
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

    @Override
    public List<Long> getStudentDocuments() {
        try {
            File file = new File("src/main/resources/text_files/student_list.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            List<Long> longList = new ArrayList<>();

            String line = reader.readLine();
            while (line != null) {
                longList.add(Long.parseLong(line));
                line = reader.readLine();
            }

            return longList;
        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return null;
    }

    @Override
    public Boolean isOK(Long studentDocument) {
        for (Long studentDoc: Objects.requireNonNull(getStudentDocuments())) {
            logger.info(studentDoc.toString());
            if (studentDoc.equals(studentDocument)) {
                return true;
            }
        }

        return false;
    }
}
