package javaScript;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver)
    {

        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack(){
       navigate.back();
    }
    public void goForward(){
        navigate.forward();
    }
    public void refreshPage(){
        navigate.refresh();
    }
    public void goTo(String url)
    {
        navigate.to(url);
    }
    public void switchToTab(String tabTitle)
    {
        var windows = driver.getWindowHandles();
        System.out.println("Number of windows is:" + windows.size());
        System.out.println("Window handels:");
        windows.forEach(System.out::println);

        for (String window : windows)
        {
            System.out.println("Switching to window" + window);
            driver.switchTo().window(window);
            System.out.println("Current window titile:" + driver.getTitle());
            if(tabTitle.equals(driver.getTitle()))
            {
                break;
            }
        }
    }
    /*
    * //Open a new tab using Ctrl + t
    *
          driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
    *
      //Switch between tabs using Ctrl + \t
          driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
    *
    *
    * */
}
