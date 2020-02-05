package com.example.demo.controller;

import com.example.demo.entity.ReservatonEntity;
import com.example.demo.service.IReservingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private IReservingService reservingService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/time/add",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    public @ResponseBody
    ReservatonEntity add(@RequestParam(name = "category") String category,
                         @RequestParam(name = "service") String service,
                         @RequestParam(name = "date") Long date,
                         @RequestParam(name = "time") Long time,
                         @RequestParam(name = "student_document") Long studentDocument) {
        ReservatonEntity reservatonEntity = new ReservatonEntity();
        reservatonEntity.setStudentDocument(studentDocument);
        reservatonEntity.setCategory(category);
        reservatonEntity.setService(service);
        reservatonEntity.setDate(new Date(date));
        return reservingService.add(reservatonEntity);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/services/{service}", produces = "application/json")
    public List<ReservatonEntity> get(@PathVariable(name = "service") String service) {
        return reservingService.getByService(service);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/reserved/{id}", produces = "application/json")
    public ReservatonEntity getByID(@PathVariable(name = "id") Long id) {
        return reservingService.get(id);
    }
}
