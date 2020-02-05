package com.example.demo.controller;

import com.example.demo.entity.ReservatonEntity;
import com.example.demo.service.IReservingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private IReservingService reservingService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/time/add",
            consumes = "application/json",
            produces = "application/json"
    )
    public @ResponseBody
    ReservatonEntity add(@RequestParam(name = "service") String service,
                         @RequestParam(name = "date") Long date,
                         @RequestParam(name = "hour") String hour,
                         @RequestParam(name = "student_document") Long studentDocument) {
        ReservatonEntity reservatonEntity = new ReservatonEntity();
        reservatonEntity.setStudentDocument(studentDocument);
        reservatonEntity.setService(service);
        reservatonEntity.setDate(new Timestamp(date));
        reservatonEntity.setHour(hour);
        return reservingService.add(reservatonEntity);
    }

    @PostMapping(
            value = "/add", consumes = "application/json", produces = "application/json")
    public ReservatonEntity addReservation(@RequestBody ReservatonEntity reservatonEntity) {
        return reservingService.add(reservatonEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/services/{service}", produces = "application/json")
    public List<ReservatonEntity> get(@PathVariable(name = "service") String service) {
        return reservingService.getByService(service);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/services/{service}/{date}/{hour}", produces = "application/json")
    public ReservatonEntity getByDate(@PathVariable(name = "service") String service,
                                @PathVariable(name = "date") Long date,
                                @PathVariable(name = "hour") String hour) {
        return reservingService.getByDate(service, new Timestamp(date), hour);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/date/{date}", produces = "application/json")
    public Timestamp getDateAtRightFormat(@PathVariable(name = "date") Long date) {
        return new Timestamp(date);         // DATE FORMAT: 1564235000000 (13 ЧИСЕЛ)
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reserved/{id}", produces = "application/json")
    public ReservatonEntity getByID(@PathVariable(name = "id") Long id) {
        return reservingService.get(id);
    }
}
