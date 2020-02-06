package com.example.demo.controller;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.exception.NullFieldsException;
import com.example.demo.exception.RecordExistException;
import com.example.demo.model.api.request.AddReservationRequest;
import com.example.demo.repository.IReservationRepository;
import com.example.demo.service.IReservingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Класс-контроллер, отвечающий за бронирование сервисов.
 */
@RestController
public class TimetableController {

    @Autowired
    private IReservingService reservingService;

    @Autowired
    private IReservationRepository iReservationRepository;

    /**
     * Добавляет запись на сервис (не используется?)
     * @param reservationEntity Запись (сущность).
     * @return Добавляет запись на сервис в виде json объекта.
     */
    @PostMapping(
            value = "add", consumes = "application/json", produces = "application/json")
    public ReservationEntity addReservation(@RequestBody ReservationEntity reservationEntity) {
        return reservingService.add(reservationEntity);
    }

    /**
     * Метод добавления записи на сервис.
     * @param addReservationRequest Добавляет
     * @return Добавляет запись на сервис в виде json объекта.
     * @throws Exception При отсутствии одного из параметров записи или при повторении записи отображается исключение.
     */
    @PostMapping(
            value = "add_v2", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> addReservationV2(@RequestBody AddReservationRequest addReservationRequest) throws Exception {

        if (addReservationRequest.getDateTime().getDate() == null
            || addReservationRequest.getDateTime().getTime() == null
            || addReservationRequest.getStudentDocument() == null
            || addReservationRequest.getService() == null)
            throw new NullFieldsException();

        Boolean isExisted = iReservationRepository.existsByDateTime_DateAndDateTime_TimeAndService(addReservationRequest.getDateTime().getDate(),
                addReservationRequest.getDateTime().getTime(), addReservationRequest.getService());

        if (isExisted) throw new RecordExistException(addReservationRequest);

        return ResponseEntity.status(HttpStatus.OK).body(reservingService.addv2(addReservationRequest));
    }

    /**
     * Выводит все сущности, относящиеся к конкретному сервису (скорее всего, надо удалить)
     * @param service Сервис записи.
     * @return Возвращает список сущностей сервиса.
     */
    @RequestMapping(method = RequestMethod.GET, path = "services_simple/{service}", produces = "application/json")
    public List<ReservationEntity> get(@PathVariable(name = "service") String service) {
        return reservingService.getByService(service);
    }

    /**
     * Дико важная функция по заказу фронтенда.
     * Выводит список часов конкретной секции в определённый день.
     * @param service Сервис записей.
     * @param date Дата, в которой необходимо просмотреть время.
     * @return Возвращает список доступных часов.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/services/{service}/{date}", produces = "application/json")
    public List<String> getByDateAndService(@PathVariable(name = "service") String service,
                                            @PathVariable(name = "date") Long date) {
        return reservingService.getByDayAndService(service, date);
    }

    /**
     * Выводит по id запись. Важна только для теста
     * @param id Идентификатор записи.
     * @return Возвращает запись.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/reserved/{id}", produces = "application/json")
    public ReservationEntity getByID(@PathVariable(name = "id") Long id) {
        return reservingService.get(id);
    }
}
