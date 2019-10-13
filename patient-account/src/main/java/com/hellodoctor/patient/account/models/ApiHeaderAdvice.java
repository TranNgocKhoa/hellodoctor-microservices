package com.hellodoctor.patient.account.models;

import com.hellodoctor.patient.account.exceptions.ApiRuntimeException;
import com.hellodoctor.patient.account.exceptions.DBOperationException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ApiHeaderAdvice {
    private boolean isSuccessful;
    private String resultCode;
    private String resultMessage;

    public ApiHeaderAdvice() {
        isSuccessful = true;
        resultCode = "0";
        resultMessage = "SUCCESS";
    }

    public ApiHeaderAdvice(ApiRuntimeException apiRuntimeException) {
        isSuccessful = false;
        resultCode = apiRuntimeException.getResultCode();
        resultMessage = apiRuntimeException.getResultMessage();
    }

    public ApiHeaderAdvice(DBOperationException dBOperationException) {
        isSuccessful = false;
        resultCode = dBOperationException.getResultCode();
        resultMessage = dBOperationException.getResultMessage();
    }

    public ApiHeaderAdvice(boolean isSuccessful, String resultCode, String resultMessage) {
        this.isSuccessful = isSuccessful;
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }
}
