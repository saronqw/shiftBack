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
 *  @version 2.0 - В файле JSON помимо списка сервисов также содержите статус отправления и код ошибки.
 *  @version 1.0 - В файле JSON содержится только список
 */
@RestController
public class ListController {

    @Autowired
    private IListSectionService iListSectionService;


    /**
     * @deprecated Метод GET запоса для спортзала (V1)
     * Метод GET запроса для спортзала.
     * @return Возвращает список сервисов спортзала.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v1/gym", produces = "application/json")
    public List<Service> getSportList() {
        return new Services().getSportList();
    }

    /**
     * Метод GET запроса для спортзала. (V2)
     * @return Возвращает список сервисов спортзала.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v2/gym", produces = "application/json")
    public ResponseEntity<?> getSportList_v2() {
        return ResponseEntity.status(HttpStatus.OK).body(iListSectionService.getServices(new Services().getSportList()));
    }

    /**
     * @deprecated Метод GET запоса для спа (V1)
     * Метод GET запроса для спа.
     * @return Возвращает список сервисов спа.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v1/spa", produces = "application/json")
    public List<Service> getSPAList() {
        return new Services().getSPAList();
    }

    /**
     * Метод GET запроса для спа. (V2)
     * @return Возвращает список сервисов спа.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v2/spa", produces = "application/json")
    public ResponseEntity<?> getSPAList_v2() {
        return ResponseEntity.status(HttpStatus.OK).body(iListSectionService.getServices(new Services().getSPAList()));
    }

    /**
     * @deprecated Метод GET запоса для бассейна (V1)
     * Метод GET запроса для бассейна.
     * @return Возвращает список сервисов бассейна.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v1/pool", produces = "application/json")
    public List<Service> getPoolList() {
        return new Services().getPoolList();
    }

    /**
     * Метод GET запроса для бассейна. (V2)
     * @return Возвращает список сервисов бассейна.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v2/pool", produces = "application/json")
    public ResponseEntity<?> getPoolList_v2() {
        return ResponseEntity.status(HttpStatus.OK).body(iListSectionService.getServices(new Services().getPoolList()));
    }


    /**
     * @deprecated Метод GET запоса для бара (V1)
     * Метод GET запроса для бара.
     * @return Возвращает список сервисов бара.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v1/bar", produces = "application/json")
    public List<Service> getBarList() {
        return new Services().getBarList();
    }

    /**
     * Метод GET запроса для бара. (V2)
     * @return Возвращает список сервисов бара.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/v2/bar", produces = "application/json")
    public ResponseEntity<?> getBarList_v2() {
        return ResponseEntity.status(HttpStatus.OK).body(iListSectionService.getServices(new Services().getBarList()));
    }
}
