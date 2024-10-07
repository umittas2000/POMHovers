package dropdown;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTests extends BaseTests {


    @Test
    public void VerifyTotalOptions() {

        //in this test method we will verify Total number of items in dropdown list.
        var dropdownPage = homePage.clickDropdownLink();
        int expectedTotalOptions = 4;

        var allOptions = dropdownPage.getAllOptions();
        Assert.assertEquals(allOptions.size(),expectedTotalOptions,"Incorrect number of Options");
    }


    @Test
    public void testSelectOption(){
        //in this test method, we will select "Option 1" item and verify selected item.
        var dropdownPage = homePage.clickDropdownLink();

        String option = "Option 1";

        dropdownPage.selectFromDropDown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();

        //Assert.assertEquals(selectedOptions.size(),1,"Incorrect number of selections");
        Assert.assertTrue(selectedOptions.contains(option));
    }

    @Test(enabled = false)
    public void VerifyOption2Item(){
        Assert.fail("Not implemented yet..");
    }

    @Test(enabled = false)
    public void VerifyDefaultSelectedItems(){
        Assert.fail("Not implemented yet..");
    }

    @Test(enabled = false)
    public void verifyPleaseSelectanOptionItem(){

        Assert.fail("Not implemented yet..");
    }
}
