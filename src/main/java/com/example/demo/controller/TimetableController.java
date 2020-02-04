package com.example.demo.controller;

import com.example.demo.entity.ReservEntity;
import com.example.demo.service.IReservingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimetableController {

    @Autowired
    private IReservingService reservingService;


    //
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/time/reserved",
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
            path = "/time/reserving",
            consumes = "application/x-www-form-urlencoded",
            produces = "application/json"
    )
    public @ResponseBody
    ReservEntity add(@RequestParam(name = "id") Long id,
                     @RequestParam(name = "category") String category,
                     @RequestParam(name = "service") String service,
                     @RequestParam(name = "date") Long date) {
        ReservEntity reserv = new ReservEntity();
        reserv.setId(id);
        reserv.setCategory(category);
        reserv.setService(service);
        reserv.setDate(date);

        return reservingService.add(reserv);
    }
}
