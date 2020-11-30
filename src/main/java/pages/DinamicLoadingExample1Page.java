package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DinamicLoadingExample1Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) div.example:nth-child(2) div:nth-child(4) > button:nth-child(1)");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    public DinamicLoadingExample1Page(WebDriver driver){
       this.driver = driver;
    }
   //Explicite and Fluent wait
    public void clickStartButton(){

        driver.findElement(startButton).click();
        //WebDriverWait wait = new WebDriverWait(driver, 5);
        //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(loadingIndicator)));


        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
                 wait.until(ExpectedConditions
                         .invisibilityOf(driver.findElement(loadingIndicator)));

                 //wait.until(ExpectedConditions.visibilityOf(WebElement);
                 //wait.until(ExpectedConditions.elementToBeClickable(WebElement);
    }
    public String getLoadedText(){

        return driver.findElement(loadedText).getText();
    }
}
