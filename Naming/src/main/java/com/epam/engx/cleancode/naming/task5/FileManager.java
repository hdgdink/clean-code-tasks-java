package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.exception.InvalidDirectoryException;
import com.epam.engx.cleancode.naming.task5.exception.InvalidFileTypeException;
import com.epam.engx.cleancode.naming.task5.service.FileExtensionPredicateServiceImpl;
import com.epam.engx.cleancode.naming.task5.service.PropertyUtilService;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public final class FileManager {

    private static final String[] IMAGES = {"jpg", "png"};
    private static final String[] TEXT_DOCS = {"pdf", "doc"};

    private String basePath = PropertyUtilService.loadProperty("basePath");
    private final String DIR_PATH = basePath + File.separator;

    public File retrieve(String fileName) {
        validateType(fileName);
        return Paths.get(DIR_PATH, fileName).toFile();
    }

    public List<String> getImageList() {
        return files(basePath, IMAGES);
    }

    public List<String> getDocumentList() {
        return files(basePath, TEXT_DOCS);
    }

    private void validateType(String fileName) {
        if (isInvalidType(fileName)) {
            throw new InvalidFileTypeException("File type not Supported: " + fileName);
        }
    }

    private boolean isInvalidType(String fileName) {
        return isInvalidImage(fileName) && isInvalidDocument(fileName);
    }

    private boolean isInvalidImage(String fileName) {
        FileExtensionPredicateServiceImpl fileExtensionPredicateService = new FileExtensionPredicateServiceImpl(IMAGES);
        return !fileExtensionPredicateService.checkIsExtension(fileName);
    }

    private boolean isInvalidDocument(String fileName) {
        FileExtensionPredicateServiceImpl documentExtensionsPredicate = new FileExtensionPredicateServiceImpl(TEXT_DOCS);
        return !documentExtensionsPredicate.checkIsExtension(fileName);
    }

    private List<String> files(String directoryPath, String[] allowedExtensions) {
        final FileExtensionPredicateServiceImpl fileExtensionPredicateService = new FileExtensionPredicateServiceImpl(allowedExtensions);
        return Arrays.asList(directory(directoryPath).list(getFilenameFilterByPredicate(fileExtensionPredicateService)));
    }

    private FilenameFilter getFilenameFilterByPredicate(final FileExtensionPredicateServiceImpl fileExtensionPredicateService) {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String str) {
                return fileExtensionPredicateService.checkIsExtension(str);
            }
        };
    }

    private File directory(String directoryPath) {
        File directory = new File(directoryPath);
        validateDirectory(directory);
        return directory;
    }

    private void validateDirectory(File directoryInstance) {
        if (isNotDirectory(directoryInstance)) {
            throw new InvalidDirectoryException("Invalid directory found: " + directoryInstance.getAbsolutePath());
        }
    }

    private boolean isNotDirectory(File dir) {
        return !dir.isDirectory();
    }

}