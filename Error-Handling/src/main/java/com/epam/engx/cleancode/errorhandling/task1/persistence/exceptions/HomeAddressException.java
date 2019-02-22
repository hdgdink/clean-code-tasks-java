package com.epam.engx.cleancode.errorhandling.task1.persistence.exceptions;

public class HomeAddressException extends RuntimeException {
    public HomeAddressException(String message) {
        super(message);
    }
}
