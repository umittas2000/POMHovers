package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage {
    private WebDriver driver;

    //Constructor
    public SecureAreaPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    //Status Alert
    private By statusAlert =By.id("flash");
    //Logout button
    private By logoutButton = By.xpath("//a[contains(@href,'logout')]");


    //Action Methods

    //Get AlertText and return Text as a String
    public String getAlertText(){
         return driver.findElement(statusAlert).getText();
    }

    public LoginPage clickLogoutButton(){
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }

    //send current URL of the page
    public String getURL(){
        return driver.getCurrentUrl();
    }
}
