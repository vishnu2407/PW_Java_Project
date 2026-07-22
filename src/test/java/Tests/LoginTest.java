package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Base.baseTest1;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class LoginTest extends baseTest1 {
	@Test
	public void test1() {
		//Login Page
		test.info("Navigating to Login page:");
		page.navigate("https://practicetestautomation.com/practice-test-login/");
		LoginPage loginPage = new LoginPage(page);
		test.info("Entering UserName and Password");
		loginPage.login("student", "Password123");
		test.info("Verify Login Button");
		Assert.assertTrue(loginPage.isLoginSuccessful(), "The login success page was not displayed.");

		//Home page
		/*HomePage homePage = new HomePage(page);
		test.info("Clicking Home Page");
		homePage.clickHome();
		test.info("Clicking Practice Page");
		homePage.clickPractice();
		test.info("Clicking Courses Page");
		homePage.clickCourses();
		test.info("Clicking Contact Page");
		homePage.clickContact();*/

	}
	@Test
	public void test2() {
		test.skip("This Test is Skipped");
		throw new SkipException("This Test is Skipped");
	}

	@Test
	public void test3() {
		//Login Page
		test.info("Navigating to Login page:");
		page.navigate("https://practicetestautomation.com/practice-test-login/");
		LoginPage loginPage = new LoginPage(page);
		test.info("Adding UserName and Password");
		loginPage.login("student", "Password123");
		test.info("Clicking Login Button");
		Assert.assertTrue(loginPage.isLoginSuccessful(), "The login success page was not displayed.");

		//Home page
		HomePage homePage = new HomePage(page);
		test.info("Clicking Home Page");
		homePage.clickHome();
		test.info("Clicking Practice Page");
		homePage.clickPractice();
		test.info("Clicking Courses Page");
		homePage.clickCourses();
		test.info("Clicking Contact Page");
		homePage.clickContact();
	}

//	@Test
//	public void test4() {
//		/*//Login Page
//		test.info("Navigating to Login page:");
//		page.navigate("https://practicetestautomation.com/practice-test-login/");
//		LoginPage loginPage = new LoginPage(page);
//		test.info("Adding UserName and Password");
//		loginPage.login("student", "Password123");
//		test.info("Clicking Login Button");
//		Assert.assertTrue(loginPage.isLoginSuccessful(), "The login success page was not displayed.");*/
//
//		//Home page
//		HomePage homePage = new HomePage(page);
//		test.info("Clicking Home Page");
//		homePage.clickHome();
//		test.info("Clicking Practice Page");
//		homePage.clickPractice();
//		test.info("Clicking Courses Page");
//		homePage.clickCourses();
//		test.info("Clicking Contact Page");
//		homePage.clickContact();
//	}

}
