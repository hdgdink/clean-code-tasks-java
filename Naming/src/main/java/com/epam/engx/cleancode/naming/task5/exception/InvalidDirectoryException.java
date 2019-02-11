package com.epam.engx.cleancode.naming.task5.exception;

public class InvalidDirectoryException extends RuntimeException{
    private String message;

    public InvalidDirectoryException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
