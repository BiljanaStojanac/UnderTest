package fileUpload;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
       var fileUpload = homePage.clickFileUpload();
       fileUpload.uploadFile("C:/Users/bstojanac/OneDrive - Sixsentix AG/Documents/Example for TAU.docx");

       assertEquals(fileUpload.uploadConfirmation(),"File Uploaded!","File is not uploaded");
       assertEquals(fileUpload.getUploadedFiles(),"Example for TAU.docx","Something is wrong");
    }
}
