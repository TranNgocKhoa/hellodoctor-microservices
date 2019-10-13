package com.hellodoctor.patient.account.enums;

public enum ErrorType {
    HTTP_400("400", "HTTP 400 error occurred."),
    HTTP_404("404", "HTTP 404 error occurred."),
    HTTP_500("500", "HTTP 500 error occurred."),
    HTTP_503("503", "HTTP 503 error occurred."),

    UPDATE_FAIL("1001", "Update record to DB failed"),
    INSERT_FAIL("1001", "Update record to DB failed");

    private String code;
    private String message;

    ErrorType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
