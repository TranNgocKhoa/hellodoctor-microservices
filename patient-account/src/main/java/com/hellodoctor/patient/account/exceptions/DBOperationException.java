package com.hellodoctor.patient.account.exceptions;

import com.hellodoctor.patient.account.enums.ErrorType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DBOperationException extends RuntimeException {
    private boolean isSuccessful;
    private String resultCode;
    private String resultMessage;

    public DBOperationException(Throwable cause) {
        super(cause);
    }

    public DBOperationException(ErrorType errorType) {
        super(errorType.getMessage());

        isSuccessful = false;
        resultCode = errorType.getCode();
        resultMessage = errorType.getMessage();
    }

    public DBOperationException(ErrorType errorType, Throwable cause) {
        super(cause);

        isSuccessful = false;
        resultCode = errorType.getCode();
        resultMessage = errorType.getMessage();
    }
}
