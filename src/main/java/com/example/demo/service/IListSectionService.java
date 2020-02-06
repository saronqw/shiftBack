package com.example.demo.service;

import com.example.demo.entity.Service;
import com.example.demo.model.api.ResultResponse;

import java.util.List;

public interface IListSectionService {
    ResultResponse getServices(List<Service> list);
}
