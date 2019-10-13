package com.hellodoctor.patient.account.models;

import com.hellodoctor.patient.account.exceptions.ApiRuntimeException;
import com.hellodoctor.patient.account.exceptions.DBOperationException;
import lombok.ToString;

@ToString
public class ApiResponseAdvice<T> {
    private ApiHeaderAdvice header = new ApiHeaderAdvice();
    private T data = null;

    public ApiResponseAdvice() {
    }

    public ApiResponseAdvice(T data) {
        this.data = data;
    }

    public ApiResponseAdvice(ApiHeaderAdvice header, T data) {
        this.header = header;
        this.data = data;
    }

    public ApiHeaderAdvice getHeader() {
        return header;
    }

    public void setHeader(ApiHeaderAdvice header) {
        this.header = header;
    }

    public void setHeader(ApiRuntimeException apiRuntimeException) {
        header = new ApiHeaderAdvice(apiRuntimeException);
    }

    public void setHeader(DBOperationException dbOperationException) {
        header = new ApiHeaderAdvice(dbOperationException);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
