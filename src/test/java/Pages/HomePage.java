package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage {

    private final Page page;

    // Constructor
    public HomePage(Page page) {
        this.page = page;
    }

    // Click Home
    public void clickHome() {
        page.getByRole(
                        AriaRole.LINK,
                        new Page.GetByRoleOptions().setName("Home")).click();
    }

    // Click Practice
    public void clickPractice() {
        page.getByRole(
                        AriaRole.LINK,
                        new Page.GetByRoleOptions()
                                .setName("Practice")
                                .setExact(true))
                .click();
    }

    // Click Courses
    public void clickCourses() {
        page.getByRole(
                        AriaRole.LINK,
                        new Page.GetByRoleOptions().setName("Courses"))
                .click();
    }

    // Click Contact
    public void clickContact() {
        page.getByRole(
                        AriaRole.LINK,
                        new Page.GetByRoleOptions().setName("Contact"))
                .click();
    }

    // Get Page Title
    public String getPageTitle() {
        return page.title();
    }

    // Get Current URL
    public String getCurrentURL() {
        return page.url();
    }

}