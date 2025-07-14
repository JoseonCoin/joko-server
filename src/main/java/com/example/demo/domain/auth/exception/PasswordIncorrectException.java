package com.example.demo.domain.auth.exception;

import com.example.demo.global.error.exception.CustomException;
import com.example.demo.global.error.exception.ErrorCode;

public class PasswordIncorrectException extends CustomException {

    public static final CustomException EXCEPTION = new PasswordIncorrectException();

    public PasswordIncorrectException() {
        super(ErrorCode.PASSWORD_INCORRECT);
    }
}
