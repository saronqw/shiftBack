package com.example.demo.service;

import com.example.demo.entity.Service;
import com.example.demo.model.api.ResultResponse;

import java.util.List;

/**
 * Интерфейс, определяющий функционал ListSectionService,
 * используемый для полученя списка сервисов.
 */
public interface IListSectionService {
    ResultResponse getServices(List<Service> list);
}
