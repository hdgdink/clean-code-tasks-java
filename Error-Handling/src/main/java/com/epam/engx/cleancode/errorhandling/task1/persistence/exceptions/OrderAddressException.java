package com.epam.engx.cleancode.errorhandling.task1.persistence.exceptions;

public class OrderAddressException extends RuntimeException {
    public OrderAddressException(String message) {
        super(message);
    }
}
