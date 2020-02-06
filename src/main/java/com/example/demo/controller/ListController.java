package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.entity.Services;
import com.example.demo.model.api.ResultResponse;
import com.example.demo.service.IListSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс-контроллер, методы которого возвращают список
 *  сервисов у категории.
 */
@RestController
public class ListController {

    @Autowired
    private IListSectionService iListSectionService;

    /**
     * Метод GET запроса для спортзала.
     * @return Возвращает список сервисов спортзала.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/gym", produces = "application/json")
    public List<Service> getSportList() {
        return new Services().getSportList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/gym_v2", produces = "application/json")
    public ResponseEntity<?> getSportList_v2() {
        return ResponseEntity.status(HttpStatus.OK).body(iListSectionService.getServices(new Services().getSportList()));
    }

    /**
     * Метод GET запроса для спа.
     * @return Возвращает список сервисов спа.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/spa", produces = "application/json")
    public List<Service> getSPAList() {
        return new Services().getSPAList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/spa_v2", produces = "application/json")
    public ResponseEntity<?> getSPAList_v2() {
        return ResponseEntity.status(HttpStatus.OK).body(iListSectionService.getServices(new Services().getSPAList()));
    }

    /**
     * Метод GET запроса для бассейне.
     * @return Возвращает список сервисов бассейна.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/pool", produces = "application/json")
    public List<Service> getPoolList() {
        return new Services().getPoolList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/pool_v2", produces = "application/json")
    public ResponseEntity<?> getPoolList_v2() {
        return ResponseEntity.status(HttpStatus.OK).body(iListSectionService.getServices(new Services().getPoolList()));
    }

    /**
     * Метод GET запроса для бара.
     * @return Возвращает список сервисов бара.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/bar", produces = "application/json")
    public List<Service> getBarList() {
        return new Services().getBarList();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/bar_v2", produces = "application/json")
    public ResponseEntity<?> getBarList_v2() {
        return ResponseEntity.status(HttpStatus.OK).body(iListSectionService.getServices(new Services().getBarList()));
    }
}
