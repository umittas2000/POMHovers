package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.SecureAreaPage;

//all of our test classes will inherit from baseTests
public class LoginTests extends BaseTests {

  @BeforeMethod
  public void beforeMethod() {

  }
    @Test
    public void testSuccessfulLogin(){

        LoginPage loginPage = homePage.clickFormAuthenticationLink();

        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();

        String actualAlertText = secureAreaPage.getAlertText();
        String expectedAlertText = "You logged into a secure area!";

        //AssertEquals compares exact same variable
        //Assert.assertEquals(actualAlertText, expectedAlertText, "AlertText is incorrect!");

        //if contains method needed, assertTrue method can be used with following:
        Assert.assertTrue(actualAlertText.contains(expectedAlertText));
    }

    @Test
    public void testSuccessfulLogout(){
        LoginPage loginPage = homePage.clickFormAuthenticationLink();

        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage =  loginPage.clickLoginButton();

        //Go back to loginPage
        loginPage = secureAreaPage.clickLogoutButton();

        //Read Logout message in LoginPage
        String ActualLogoutMessage = loginPage.getSuccessfulLogoutMessage();
        String ExpectedLogoutMessage = "You logged out";

        //if contains method needed, assertTrue method can be used with following:
        Assert.assertTrue(ActualLogoutMessage.contains(ExpectedLogoutMessage));
    }

}
