package com.example.demo.controller;

import com.example.demo.entity.Service;
import com.example.demo.entity.Services;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Класс-контроллер, методы которого возвращают список
 *  сервисов у категории.
 */
@RestController
public class ListController {
    /**
     * Метод GET запроса для спортзала.
     * @return Возвращает список сервисов спортзала.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/gym", produces = "application/json")
    public List<Service> getSportList() {
        return new Services().getSportList();
    }
    /**
     * Метод GET запроса для спа.
     * @return Возвращает список сервисов спа.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/spa", produces = "application/json")
    public List<Service> getSPAList() {
        return new Services().getSPAList();
    }

    /**
     * Метод GET запроса для бассейне.
     * @return Возвращает список сервисов бассейна.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/pool", produces = "application/json")
    public List<Service> getPoolList() {
        return new Services().getPoolList();
    }

    /**
     * Метод GET запроса для бара.
     * @return Возвращает список сервисов бара.
     */
    @RequestMapping(method = RequestMethod.GET, path = "/bar", produces = "application/json")
    public List<Service> getBarList() {
        return new Services().getBarList();
    }
}
