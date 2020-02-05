package com.example.demo.controller;

import com.example.demo.sections.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @RequestMapping(method = RequestMethod.GET, path = "/categories/trainings", produces = "application/json")
    public TrainingList[] getTrainingsList() {
        return TrainingList.values();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/gym", produces = "application/json")
    public SportList[] getSportList() {
        return SportList.values();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/spa", produces = "application/json")
    public SPAList[] getSPAList() {
        return SPAList.values();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pool", produces = "application/json")
    public PoolList[] getPoolList() {
        return PoolList.values();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bar", produces = "application/json")
    public BarList[] getBarList() {
        return BarList.values();
    }

}
