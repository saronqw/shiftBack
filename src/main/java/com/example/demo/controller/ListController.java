package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.entity.Services;
import com.example.demo.sections.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListController {

    // Ниже расположены три функции (надо замменить на двуязычные списки, пример в самом низу)
    @RequestMapping(method = RequestMethod.GET, path = "/gym", produces = "application/json")
    public List<Service> getSportList() {
        return new Services().getSportList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/spa", produces = "application/json")
    public List<Service> getSPAList() {
        return new Services().getSPAList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pool", produces = "application/json")
    public List<Service> getPoolList() {
        return new Services().getPoolList();
    }

    /**
     * Возвращает список сервисов бара аж в 2-ух языках
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, path = "/bar", produces = "application/json")
    public List<Service> getBarList() {
        return new Services().getBarList();
    }
}
