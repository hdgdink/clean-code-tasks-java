package com.epam.engx.cleancode.naming.task5.exception;

public class MissingConfigFileException extends RuntimeException {
    private final String message;

    public MissingConfigFileException(String message) {
        super(message);
        this.message = message;
    }

    public MissingConfigFileException(String message, Exception e) {
        super(message, e);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
