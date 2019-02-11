package com.epam.engx.cleancode.naming.task5;

import com.epam.engx.cleancode.naming.task5.exception.InvalidFileTypeException;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class FileManagerTest {

    private FileManager fileManager = new FileManager();

    @Test
    public void should_listAllImageFiles() {
        List<String> imageList = fileManager.getImageList();
        Assert.assertNotNull(imageList);
        Assert.assertEquals(imageList.size(), 1);
        Assert.assertEquals(imageList.get(0), "epam.png");
    }

    @Test
    public void should_listAllDocumentFiles() {
        List<String> documentFiles = fileManager.getDocumentList();
        Assert.assertNotNull(documentFiles);
        Assert.assertEquals(documentFiles.size(), 1);
        Assert.assertEquals(documentFiles.get(0), "sample.doc");
    }

    @Test
    public void should_retrieveFile_when_validImage() {
        File image = fileManager.retrieve("epam.png");
        Assert.assertTrue(image.exists());
    }

    @Test(expected = InvalidFileTypeException.class)
    public void should_throwException_when_unsupportedImageType() {
        fileManager.retrieve("invalidImage.img");
    }

    @Test
    public void should_returnEmpty_when_noImageExists() {
        File image = fileManager.retrieve("invalidImage.jpg");
        Assert.assertFalse(image.exists());
    }

    @Test
    public void should_retrieveFile_when_validDocument() {
        File document = fileManager.retrieve("sample.doc");
        Assert.assertTrue(document.exists());
    }

    @Test(expected = InvalidFileTypeException.class)
    public void should_throwException_when_unsupportedDocumentType() {
        fileManager.retrieve("invalidDoc.java");
    }

    @Test(expected = InvalidFileTypeException.class)
    public void should_throwException_when_retrieveFileWithNoExtension() {
        fileManager.retrieve("noExtension");
    }

    @Test
    public void should_returnEmpty_when_noDocumentExists() {
        File document = fileManager.retrieve("invalidDoc.pdf");
        Assert.assertFalse(document.exists());
    }
}
