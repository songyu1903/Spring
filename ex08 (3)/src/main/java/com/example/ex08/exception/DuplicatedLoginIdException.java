package com.example.ex08.exception;

public class DuplicatedLoginIdException extends Exception {
    public DuplicatedLoginIdException(String message) {
        super(message);
    }
}
