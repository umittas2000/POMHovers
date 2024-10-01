package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    //Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button");
    private By successfulLogoutMessage = By.id("flash");

    //Action Methods

    //send username to username input field web element
    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    //send password to password input field web element
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    //Click login button and return handle to understand driver's current state.
    public SecureAreaPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new SecureAreaPage(driver);
    }

    //get Successful logout Test
    public String getSuccessfulLogoutMessage() {
        return driver.findElement(successfulLogoutMessage).getText();
    }

    //Send currentURL of the page
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
