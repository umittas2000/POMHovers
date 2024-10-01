package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;

    //Constructor
    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private By dropDown = By.id("dropdown");



    //Action Methods
    public void selectFromDropDown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();

        return selectedElements.stream()
                .map(e->e.getText()).collect(Collectors.toList());

    }

    public List<String> getAllOptions(){
        /*
          stream is converting array to the list
          Lambda expression is used to
          manipulate array data within streams
         */

        List<WebElement> allElements = findDropdownElement().getOptions();


        return allElements.stream()
                .map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(dropDown));
    }
}
