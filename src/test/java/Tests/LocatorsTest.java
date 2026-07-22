package Tests;

import Base.baseTest1;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class LocatorsTest extends baseTest1 {
    @Test
    public void testAllLocators(){
        page.navigate("https://trytestingthis.netlify.app/");

        //Locators
        //First Name using ID attribute
        page.locator("#fname").fill("Tom");

        //Last Name using name attribute
        page.locator("input[name='lname']").fill("Holland");

        //Radio Buttons using single value
        //page.locator("input[value='male']").check();
        //Radio Buttons using index value - Nth Element - Selecting from the index manually
        page.locator("input[type='radio']").nth(0).check();

        //Dropdown using ID
        page.locator("#option").selectOption("option 3");

        //Check Boxes using type attribute - Nth Element - Select from the index manually
        //page.locator("input[type='checkbox']").nth(0).check();
        //Check Boxes using input name attribute
        //page.locator("input[name='Option 1']").check();
        //Check Boxes using label attribute
        page.getByLabel("Option 1").check();

        //Check using Xpath(avoid if possible, but sometimes needed)
        page.locator("input[id='day']").fill("1996-06-01");

        //Role Selector for accessibility
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
        page.pause();
    }
}