package com.example.demo.service;

import com.example.demo.entity.Service;
import com.example.demo.model.api.ResponseCode;
import com.example.demo.model.api.ResponseStatus;
import com.example.demo.model.api.ResultResponse;
import java.util.List;

@org.springframework.stereotype.Service
public class ListSectionService implements IListSectionService {

    @Override
    public ResultResponse getServices(List<Service> list) {
        ResultResponse resultResponse = new ResultResponse();
        ResponseStatus status = new ResponseStatus();
        status.setCode(ResponseCode.OK.getCode());
        resultResponse.setStatus(status);
        resultResponse.setData(list);
        return resultResponse;
    }
}
