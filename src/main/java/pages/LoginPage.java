package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;

    }

    public void setUsername(String username)
    {
        WebDriverWait wait = new WebDriverWait(driver,20);
        WebElement element = driver.findElement(usernameField);
        wait.until(ExpectedConditions.visibilityOf((WebElement) usernameField));
        element.sendKeys(username);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void setPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);

    }


}
