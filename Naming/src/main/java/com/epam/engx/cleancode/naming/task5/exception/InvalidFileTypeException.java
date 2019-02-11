package com.epam.engx.cleancode.naming.task5.exception;

public class InvalidFileTypeException extends RuntimeException {
    private String message;

    public InvalidFileTypeException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
