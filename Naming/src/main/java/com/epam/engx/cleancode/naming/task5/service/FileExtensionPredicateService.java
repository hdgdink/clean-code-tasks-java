package com.epam.engx.cleancode.naming.task5.service;

public interface FileExtensionPredicateService<T> {

    boolean checkIsExtension(T fileName);
}
