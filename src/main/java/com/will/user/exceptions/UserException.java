package com.will.user.exceptions;

import java.io.Serializable;

public class UserException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    UserExceptionCode userExceptionCode;

    public UserException(UserExceptionCode userExceptionCode, String message) {
        super(message);
        this.userExceptionCode = userExceptionCode;
    }

    public UserExceptionCode getExceptionCode() {
        return userExceptionCode;
    }
}
