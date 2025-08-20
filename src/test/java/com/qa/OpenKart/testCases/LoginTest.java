package com.qa.OpenKart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Feature("OPENKART LOGIN FEATURE")
@Epic("Epic TEST123 : Login")
@Story("Story TEST222: Login Implementation")
public class LoginTest extends BaseTest {

	@Severity(SeverityLevel.NORMAL)
	@Owner("Designed by anil")
	@Description("Test case to validate title Account Login page")
	@Test(priority = 0)
	public void testTitleLoginPage() {
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}

	@Severity(SeverityLevel.NORMAL)
	@Owner("Designed by anil")
	@Description("Test case to validate url")
	@Test(priority = 2)
	public void testLoginUrl() {
		String actualUrl = loginpage.getCurrentLoginPageUrl();
		Assert.assertEquals(true, (actualUrl.contains("login")));
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Designed by anil")
	@Description("Test case to validate user login function")
	@Test(priority = 3)
	public void testLogin() throws InterruptedException, IOException {
		accountpage=loginpage.doLogin("skyfall1997@gmail.com", "Oracle123");
		Assert.assertEquals(true, (accountpage.getAccountPageTitle().contains("My Account")));
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Designed by anil")
	@Description("Test case to validate forgot link")
	@Test(priority = 0)
	public void verifyForgetPasswordIsDisplayed() {
		boolean checkValue = loginpage.isForgotPasswordExist();
		Assert.assertEquals(checkValue, true);
	}
	
	/*Should assert with registeration page 
	 * pending the code
	 */
	@Test
	public void verifyRegisterBtnClicked() {
		loginpage.clickElementInAppServicesList("Register");
	}

}
