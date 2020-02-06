package com.example.demo.controller;

import com.example.demo.exception.RecordExistException;
import com.example.demo.model.api.ResponseCode;
import com.example.demo.model.api.ResponseStatus;
import com.example.demo.model.api.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Класс обработчика ошибок.
 */
@ControllerAdvice
public class ErrorController {
    /**
     * Метод обработчика ошибок.
     * @param e Исключение.
     * @return Возвращает сообщение об ошибке.
     */
    @ExceptionHandler
    public ResponseEntity<ResultResponse> handleException(Exception e) {

        ResultResponse resultResponse = new ResultResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseCode.ERROR.getCode());
        responseStatus.setErrorMessage("Заданы неверные параметры");
        resultResponse.setStatus(responseStatus);
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }

    @ExceptionHandler(value = RecordExistException.class)
    public ResponseEntity<Object> handleException(RecordExistException e) {
        ResultResponse resultResponse = new ResultResponse();
        ResponseStatus responseStatus = new ResponseStatus();
        responseStatus.setCode(ResponseCode.ERROR.getCode());
        responseStatus.setErrorMessage("Данное время уже занято");
        resultResponse.setStatus(responseStatus);
        resultResponse.setData(e.getAddReservationRequest());
        return ResponseEntity.status(HttpStatus.OK).body(resultResponse);
    }
}
