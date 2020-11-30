package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class AlertsTests extends BaseTests {

    @Test
    public void TestAcceptAlert()
    {
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResults(), "You successfuly clicked an alert", "Results text is incorrect");
    }
    @Test
    public void testGetTextFromAlert(){

        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerConfirm();
       // assertEquals(alertPage.alert_getText(), "I am a JS Confirm","Alert text is inccorect");
        String text = alertPage.alert_getText();
        alertPage.alert_clickToCancel();
        assertEquals(text, "I am a JS Confirm","Alert text is incorrect");

    }
    @Test
    public void testSeTInputForAlert(){

        var alertPage = homePage.clickJavaScriptAlerts();
        alertPage.triggerPrompt();
        String text ="Hello";
        alertPage.alert_setInput(text);
        alertPage.alert_clickToAccept();
        assertEquals(alertPage.getResults(), "You entered: " + text, "Result is inccorect");
    }
}
