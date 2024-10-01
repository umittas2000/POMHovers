package dropdown;

import base.BaseTests;
import jdk.jshell.spi.ExecutionControl;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class DropdownTests extends BaseTests {


    @Test
    public void VerifyTotalOptions() {
        var dropdownPage = homePage.clickDropdownLink();
        int expectedTotalOptions = 3;

        var allOptions = dropdownPage.getAllOptions();
        Assert.assertEquals(allOptions.size(),expectedTotalOptions,"Incorrect number of Options");
    }

    @Test
    public void VerifyOption2Item(){
        Assert.fail("Not implemented yet..");
    }

    @Test
    public void VerifyDefaultSelectedItems(){
        Assert.fail("Not implemented yet..");
    }

    @Test
    public void verifyPleaseSelectanOptionItem(){

        Assert.fail("Not implemented yet..");
    }

    @Test
    public void testSelectOption(){

        var dropdownPage = homePage.clickDropdownLink();

        String option = "Option 1";

        dropdownPage.selectFromDropDown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();

        Assert.assertEquals(selectedOptions.size(),1,"Incorrect number of selections");

        Assert.assertTrue(selectedOptions.contains(option));
    }
}
