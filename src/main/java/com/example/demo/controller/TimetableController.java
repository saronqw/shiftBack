package com.example.demo.controller;

import com.example.demo.entity.ReservEntity;
import com.example.demo.sections.*;
import com.example.demo.service.IReservingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimetableController {

    @Autowired
    private IReservingService reservingService;

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/time/pastreserved",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    public int getBusyTime(@RequestParam(name = "category") String category,
                           @RequestParam(name = "service") String service,
                           @RequestParam(name = "date") Long date) {
        //return busService.add(bus);
        return 0;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/time/add",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    public @ResponseBody
    ReservEntity add(@RequestParam(name = "id") Long id,
                     @RequestParam(name = "category") String category,
                     @RequestParam(name = "service") String service,
                     @RequestParam(name = "date") Long date) {
        ReservEntity reserv = new ReservEntity(id, category, service, date);
        return reservingService.add(reserv);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categories/trainings", produces = "application/json")
    public TrainingList[] getTrainingsList() {
        return TrainingList.values();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categories/sports", produces = "application/json")
    public SportList[] getSportList() {
        return SportList.values();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categories/spa", produces = "application/json")
    public SPAList[] getSPAList() {
        return SPAList.values();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categories/pool", produces = "application/json")
    public PoolList[] getPoolList() {
        return PoolList.values();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/categories/bar", produces = "application/json")
    public BarList[] getBarList() {
        return BarList.values();
    }

}
