package Pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {

	private final Page page;

	// Locators
    // Constructor
	public LoginPage(Page page) {
		this.page = page;
	}

	// Page Action Methods

    public void login(String username, String password) {
		page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Username")).fill(username);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Password")).fill(password);
		page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).click();
	}
	// Verify successful login
	public boolean isLoginSuccessful() {
		page.waitForURL("**/logged-in-successfully/");
		return page.getByRole(
						AriaRole.HEADING,
						new Page.GetByRoleOptions()
								.setName("Logged In Successfully"))
				.isVisible();
	}
	// Logout
//	public void logout() {
//		page.getByRole(
//						AriaRole.LINK,
//						new Page.GetByRoleOptions().setName("Log out"))
//				.click();
//	}
	// Log out and verify the success page
//	public boolean isLoggedoutSuccessful() {
//		page.waitForURL("**/logged-out-successfully/");
//		return page.getByRole(
//						AriaRole.HEADING,
//						new Page.GetByRoleOptions()
//								.setName("Logged Out Successfully"))
//				.isVisible();
//	}

}
