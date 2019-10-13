package com.hellodoctor.patient.account.controllers;

import com.hellodoctor.patient.account.enums.ErrorType;
import com.hellodoctor.patient.account.exceptions.ApiRuntimeException;
import com.hellodoctor.patient.account.exceptions.DBOperationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandlerController {

    @ExceptionHandler(DBOperationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public DBOperationException internalServerError(ServerHttpRequest request, DBOperationException e) {
        this.printLog(request, e);
        return e;
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    public ApiRuntimeException internalServerError(ServerHttpRequest request, RuntimeException e) {
        this.printLog(request, e);

        return new ApiRuntimeException(ErrorType.HTTP_503);
    }

    private void printLog(ServerHttpRequest request, Exception e) {
        log.error("handleException error :: uri -> {} :: msg -> {} :: class -> {}",
                request.getURI(), e.getMessage(), e.getClass(), e);
    }

}
