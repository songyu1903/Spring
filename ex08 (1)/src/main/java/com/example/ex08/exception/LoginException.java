package com.example.ex08.exception;

public class LoginException extends RuntimeException{
    public LoginException(String message) {
        super(message);
    }
}
