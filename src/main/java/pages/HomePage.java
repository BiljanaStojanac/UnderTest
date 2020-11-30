package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }
    public LoginPage clickFormAuthentication(){
          clickLink("Form Authentication");
          return new LoginPage(driver);
    }

    public DropdownPage clickDropDown(){
        clickLink("Dropdown");
        return new DropdownPage(driver);
    }
    public HoversPage clickHovers()
    {
        clickLink("Hovers");
        return new HoversPage(driver);
    }
    public KeyPressesPage clickKeyPresses(){
        clickLink("Key Presses");
        return new KeyPressesPage(driver);

    }
    public AlertsPage clickJavaScriptAlerts(){
        clickLink("JavaScript Alerts");
        return new AlertsPage(driver);
    }
    public FileUploadPage clickFileUpload(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }
    public FrameWysiwygEditorPage clickWysiwygEditor(){
        clickLink("WYSIWYG Editor");
        return new FrameWysiwygEditorPage(driver);
    }
    public DinamicLoadingPage clickDinamicLoading(){
        clickLink("Dynamic Loading");
        return new DinamicLoadingPage(driver);
    }
    public LargeAndDeepDomPage clickLargeAndDeepDom(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDomPage (driver);
    }
    public InfiniteScrollPage clickInfiniteScroll(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }
    public MultipleWindowsPage clickMultipleWindows(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
    private void clickLink(String linkText)
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement element = driver.findElement(By.linkText(linkText));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }
}
