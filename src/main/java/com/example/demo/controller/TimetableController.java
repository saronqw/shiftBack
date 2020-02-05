package com.example.demo.controller;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.service.IReservingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private IReservingService reservingService;

    /**
     * Бесполезна, фронту не нужна.
     * Скорее всего, надо удалить.
     * @param service
     * @param date
     * @param hour
     * @param studentDocument
     * @return
     */
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/time/add",
            consumes = "application/json",
            produces = "application/json"
    )
    public @ResponseBody
    ReservationEntity add(@RequestParam(name = "service") String service,
                          @RequestParam(name = "date") Long date,
                          @RequestParam(name = "hour") String hour,
                          @RequestParam(name = "student_document") Long studentDocument) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setStudentDocument(studentDocument);
        reservationEntity.setService(service);
        return reservingService.add(reservationEntity);
    }

    /**
     * Добавляет запись на сервис
     * @param reservationEntity
     * @return
     */
    @PostMapping(
            value = "/add", consumes = "application/json", produces = "application/json")
    public ReservationEntity addReservation(@RequestBody ReservationEntity reservationEntity) {
        return reservingService.add(reservationEntity);
    }

    /**
     * Выводит все сущности, относящиеся к конкретному сервису (скорее всего, надо удалить)
     * @param service
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/services_simple/{service}", produces = "application/json")
    public List<ReservationEntity> get(@PathVariable(name = "service") String service) {
        return reservingService.getByService(service);
    }

    /**
     * Дико важная функция по заказу фронтенда.
     * Выводит список часов конкретной секции в определённый день.
     * @param service
     * @param date
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/services/{service}/{date}", produces = "application/json")
    public List<String> getByDateAndService(@PathVariable(name = "service") String service,
                                            @PathVariable(name = "date") Long date) {
        return reservingService.getByDayAndService(service, date);
    }

    /**
     * Выводит по id запись. Важна только для теста
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/reserved/{id}", produces = "application/json")
    public ReservationEntity getByID(@PathVariable(name = "id") Long id) {
        return reservingService.get(id);
    }
}
