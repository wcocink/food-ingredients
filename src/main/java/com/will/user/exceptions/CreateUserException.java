package com.will.user.exceptions;

public class CreateUserException extends UserException {

    public CreateUserException(ExceptionCode exceptionCode, String message) {
        super(exceptionCode, message);
    }

}
