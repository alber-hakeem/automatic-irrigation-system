package com.digitalfactory.baseservice.exception.custom;

public class AuthorizationException extends RuntimeException{
    public AuthorizationException(String message) {
        super(message);
    }
}
