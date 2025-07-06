package com.qa.OpenKart.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;
import com.qa.Utilities.Constants;

public class LoginTest extends BaseTest {

	@Test(priority=1)
	public void testTitleLoginPage() {
		String actualTitle =loginpage.getLoginPageTile();
		Assert.assertEquals(actualTitle,"Account Login");
		}
	@Test(priority=2)
	public void testLoginUrl() {
		String actualUrl=loginpage.getCurrentLoginPageUrl();
		Assert.assertEquals(true, (actualUrl.contains("login")));
	}
	@Test(priority=3)
	public void testLogin() throws InterruptedException, IOException {
		String actSuccessTitle=loginpage.doLogin(Constants.USER_NAME,Constants.PASSWORD);
		Assert.assertEquals(true, (actSuccessTitle.contains("My Account")));
		
		
	}

}
