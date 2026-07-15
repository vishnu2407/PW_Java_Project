package Tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import Base.baseTest1;

public class Test1 extends baseTest1 { // extended from Base package

	@Test // TestNG annotation
	public void verifyTitle() {
		page.navigate("https://www.google.com/ncr");
		// Optional Handle cookie popup
		if (page.isVisible("button:has-text('Accept all')")) {
			page.click("button:has-text('Accept all')");
		}
		System.out.println("Google NCR opened successfully....!");
		System.out.println("Page Title:" + page.title());
	}

	@Test
	public void verifyPage() {
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		if(page.isVisible("button:has-text('Accept all')")) {
			page.click("button:has-text'Accept all')");
		}
		System.out.println("OrangeHRM live opened successfully....!");
		System.out.println("Page Title:" + page.title());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			Page page = browser.newPage();
			page.navigate("https://www.google.com/ncr");
			page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			System.out.println("The page Title is:" + page.title());
			browser.close();
		}
	}

}
