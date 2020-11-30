package base;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CaptureScreenshots;
import javaScript.WindowManager;
import utils.EventReporter;

import java.util.concurrent.TimeUnit;

public class BaseTests {
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp()
    {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        //implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();
        //setCookie();
        deleteAllCookies();

        homePage = new HomePage(driver);


     /*

        // driver.manage().window().setSize(new Dimension(375,812));
        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
        inputsLink.click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());

        System.out.println(driver.getTitle());
      //  driver.quit();*/

    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
    }
  /*  @AfterMethod
    public void takeScreenshot(){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);

        try
        {

            Files.move(screenshot,new File("resources/screenshots/test.png"));


        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }*/
    @AfterMethod
     public void tearDownScreenshot(ITestResult result)
     {

      if(ITestResult.FAILURE==result.getStatus())
      {
          CaptureScreenshots.capturescreen(driver,result.getName(),"FAILURE");
      }
      else
          {
          CaptureScreenshots.capturescreen(driver,result.getName(),"SUCCESS");
           }
      }

     @AfterClass
    public void tearDown(){
        driver.quit();
    }

     public WindowManager getWindowManager(){
        return new WindowManager(driver);
     }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
       // options.setHeadless(true); execute test without opening Browser
        return options;
    }
    private void setCookie(){

        Cookie cookie = new Cookie.Builder("tau","123")
                .domain("https://the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);

    }
    private void deleteAllCookies()
    {
        driver.manage().deleteAllCookies();
    }

}
