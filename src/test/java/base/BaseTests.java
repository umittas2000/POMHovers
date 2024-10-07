package base;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;


    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Wait maximum 5 seconds for each element interaction before throwing the error.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //This is only for move driver browser to display2
        //driver.manage().window().setPosition(new Point(2000,0));//display 2

        driver.get("https://the-internet.herokuapp.com/");
        //home page handle
        homePage = new HomePage(driver);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
