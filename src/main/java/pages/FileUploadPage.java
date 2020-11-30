package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {

    private WebDriver driver;
    public FileUploadPage(WebDriver driver)
    {
        this.driver = driver;
    }
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadConfirmation = By.xpath("//h3[contains(text(),'File Uploaded!')]");
    private By uploadedFiles = By.id("uploaded-files");

    private void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }
    public void uploadFile(String absolutePathOfFile)
    {
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }
    public String uploadConfirmation(){

        return driver.findElement(uploadConfirmation).getText();
    }
    public String getUploadedFiles(){
        return driver.findElement(uploadedFiles).getText();
    }
}
