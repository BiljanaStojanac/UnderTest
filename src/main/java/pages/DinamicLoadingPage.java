package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
// Waits
public class DinamicLoadingPage {

    private WebDriver driver;
    private By ExampleLink1 = By.xpath("//a[contains(text(),'Example 1: Element on page that is hidden')]");

    public DinamicLoadingPage(WebDriver driver)
    {
        this.driver = driver;
    }
     public DinamicLoadingExample1Page clickExample1(){

        driver.findElement(ExampleLink1).click();
        return new DinamicLoadingExample1Page(driver);
     }

}
