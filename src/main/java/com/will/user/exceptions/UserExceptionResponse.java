package com.will.user.exceptions;

public class UserExceptionResponse {

    private String message;
    private ExceptionCode exceptionCode;

    public UserExceptionResponse(String message, ExceptionCode exceptionCode) {
        this.message = message;
        this.exceptionCode = exceptionCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }
}
