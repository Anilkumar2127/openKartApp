package com.qa.OpenKart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

public class LoginTest extends BaseTest {

	@Test(priority = 0)
	public void testTitleLoginPage() {
		String actualTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}

	@Test(priority = 2)
	public void testLoginUrl() {
		String actualUrl = loginpage.getCurrentLoginPageUrl();
		Assert.assertEquals(true, (actualUrl.contains("login")));
	}

	@Test(priority = 3)
	public void testLogin() throws InterruptedException, IOException {
		accountpage=loginpage.doLogin("skyfall1997@gmail.com", "Oracle123");
		Assert.assertEquals(true, (accountpage.getAccountPageTitle().contains("My Account")));
	}

	@Test(priority = 0)
	public void verifyForgetPasswordIsDisplayed() {
		boolean checkValue = loginpage.isForgotPasswordExist();
		Assert.assertEquals(checkValue, true);
	}
	@Test
	
	public void verifyRegisterBtnClicked() {
		loginpage.clickElementInAppServicesList("Register");
	}

}
