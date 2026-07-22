package Base;

import Util.ExtentManager;
import Util.ScreenshotsUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import java.lang.reflect.Method;

public class baseTest1 {

	protected Playwright playwright;
	protected Browser browser;
	protected Page page;
	protected ExtentReports extent;
	protected ExtentTest test;
	
	@BeforeMethod //annotation from testNG
	public void setup(Method method) {
		//Reporting Logi
		extent = ExtentManager.getInstance();
		test = extent.createTest(method.getName());
		//Playwright Setup
		playwright= Playwright.create();
		browser= playwright.chromium().launch(
				new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false).setSlowMo(1000));
		page = browser.newPage();
		page.setDefaultTimeout(4000);
	}
	
	@AfterMethod //annotation from testNG
	public void teardown(ITestResult result) {
		//Reporting Logic
		if (result.getStatus() == ITestResult.FAILURE) {
			test.fail(result.getThrowable());
			test.addScreenCaptureFromBase64String(
					ScreenshotsUtil.takeScreenshotAsBase64(page), "Failure screenshot");
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test passed");
			test.addScreenCaptureFromBase64String(
					ScreenshotsUtil.takeScreenshotAsBase64(page), "Test screenshot");
		} else{
			test.skip("Test skipped");
	    }
		extent.flush();

		//Browser Cleanup
		if(browser!= null) browser.close();
		if(playwright!= null) playwright.close();
	}

}
