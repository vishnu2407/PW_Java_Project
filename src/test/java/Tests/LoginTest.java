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
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();
			page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill("Admin");
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).click();
			page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill("admin123");
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Info")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Claim")).click();

		}
	}

}
