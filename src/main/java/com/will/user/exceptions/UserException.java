package com.will.user.exceptions;

import java.io.Serializable;

public class UserException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    ExceptionCode exceptionCode;

    public UserException(ExceptionCode exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }
}
