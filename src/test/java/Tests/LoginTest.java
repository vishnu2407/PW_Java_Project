package Tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.*;
import Base.baseTest1;
import org.testng.annotations.Test;

public class LoginTest extends baseTest1 {
	@Test
	public void test() {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://practicetestautomation.com/practice-test-login/");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("student");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("Password123");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
			page.navigate("https://practicetestautomation.com/logged-in-successfully/");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Practice").setExact(true)).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Blog")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Contact")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Courses")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home")).click();
			page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Dmitry Shyshkin, your")).click();
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close")).click();

		}
	}

}
