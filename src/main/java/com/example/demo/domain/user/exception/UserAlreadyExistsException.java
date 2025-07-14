package com.example.demo.domain.user.exception;

import com.example.demo.global.error.exception.CustomException;
import com.example.demo.global.error.exception.ErrorCode;

public class UserAlreadyExistsException extends CustomException {

    public static final CustomException EXCEPTION = new UserAlreadyExistsException();

    public UserAlreadyExistsException() {
        super(ErrorCode.USER_ALREADY_EXISTS);
    }
}
