package com.will.user.exceptions;

public class UserExceptionResponse {

    private String message;
    private String exceptionCode;
    private String exceptionMessage;

    public UserExceptionResponse(String message, String exceptionCode, String exceptionMessage) {
        this.message = message;
        this.exceptionCode = exceptionCode;
        this.exceptionMessage = exceptionMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}
