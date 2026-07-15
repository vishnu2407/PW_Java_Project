package Base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class baseTest1 {

	protected Playwright playwright;
	protected Browser browser;
	protected Page page;
	
	@BeforeMethod //annotation from testNG
	public void setup() {
		playwright= Playwright.create();
		browser= playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
		page = browser.newPage();
	}
	
	@AfterMethod //annotation from testNG
	public void teardown() {
		if(browser!= null) browser.close();
		if(playwright!= null) playwright.close();
	}

}
