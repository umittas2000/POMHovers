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

    //This method will return all selected option items
    //from dropdown web element, it may have more than 1 selectable option.
    public List<String> getSelectedOptions(){

        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();

        return selectedElements.stream()
                .map(e->e.getText()).collect(Collectors.toList());

    }

    //This method will return all option items in Dropdown web element
    public List<String> getAllOptions(){
        /*
          stream is converting array to the list
          Lambda expression is used to
          manipulate array data within streams
         */

        List<WebElement> allElements = findDropdownElement().getOptions();

        //This is stream API with lambda expression
        //it take Web Element List collection object
        //Select Text variables inside each Web element object in the list collection
        //convert them into String List colleciton and return as output.
        return allElements.stream()
                .map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(dropDown));
    }
}
