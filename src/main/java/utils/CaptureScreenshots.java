package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureScreenshots {
    private WebDriver driver;
    public CaptureScreenshots(WebDriver driver)
    {
        this.driver = driver;
    }
    private static final DateFormat dateFormat = new SimpleDateFormat("  dd_M_yyyy     HH mm ss");
    public static void capturescreen(WebDriver driver, String screenShotName, String status) {
        try {
           TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

            Date today = new Date();
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

            if (status.equals("FAILURE")) {
                FileUtils.copyFile(scrFile, new File("resources/ScreenshotsFailure/" + screenShotName + dateFormat.format(today) + ".png"));
            } else if (status.equals("SUCCESS")) {
                FileUtils.copyFile(scrFile, new File("resources/ScreenshotsSuccess/" + screenShotName + dateFormat.format(today) + ".png"));
            }


            System.out.println("Printing screen shot taken for className " + screenShotName);

        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }

    }
}

