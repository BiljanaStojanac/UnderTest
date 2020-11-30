package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
  @Test
    public void testSuccessfullogin(){

      LoginPage loginPage = homePage.clickFormAuthentication();
      loginPage.setUsername("tomsmith");
      loginPage.setPassword("SuperSecretPassword!");

     SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
      assertTrue(secureAreaPage.getAlertText()
                      .contains("You logged into a secure area!"),
                      "Alert text is incorrect");
    }
}
