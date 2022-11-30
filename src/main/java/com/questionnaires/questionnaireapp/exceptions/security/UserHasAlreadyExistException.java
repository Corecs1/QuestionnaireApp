package com.questionnaires.questionnaireapp.exceptions.security;

import org.springframework.security.core.AuthenticationException;

public class UserHasAlreadyExistException extends AuthenticationException {

    public UserHasAlreadyExistException(String msg) {
        super(msg);
    }
}
