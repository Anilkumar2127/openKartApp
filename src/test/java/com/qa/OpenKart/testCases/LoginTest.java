package com.qa.OpenKart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

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
	public void testLogin() {
		String actSuccessTitle=loginpage.doLogin("skyfall1997@gmail.com","Oracle123");
		Assert.assertEquals(true, (actSuccessTitle.contains("My Account")));
		
		
	}

}
