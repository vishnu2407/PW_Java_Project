package Pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// Locators
	private final String usernameInput = "input(name='username')";
	private final String passwordInput = "input(name='password')";
	private final String loginButton = "input(name='submit')";

	// Constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	// Page Action Methods
	public void navigate() {
		page.navigate("https://practicetestautomation.com/practice-test-login/");
	}

	public void login(String username, String password) {
		page.fill(usernameInput, username);
		page.fill(passwordInput, password);
		page.click(loginButton);
	}
}
