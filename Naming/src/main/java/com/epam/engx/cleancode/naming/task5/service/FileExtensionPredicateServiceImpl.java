package com.epam.engx.cleancode.naming.task5.service;


public class FileExtensionPredicateServiceImpl implements FileExtensionPredicateService<String> {

    private String[] extensions;

    public FileExtensionPredicateServiceImpl(String[] extensions) {
        this.extensions = extensions;
    }

    @Override
    public boolean checkIsExtension(String fileName) {
        for (String extension : extensions) {

            if (fileName.toLowerCase().endsWith(extension)) {
                return true;
            }
        }

        return false;
    }
}
