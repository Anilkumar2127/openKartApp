package com.qa.OpenKart.testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;


public class AccountTest extends BaseTest {

	
	@BeforeClass
	public void doAccSetUp(){
		accountpage=loginpage.doLogin("skyfall1997@gmail.com", "Oracle123");
	}
	
	@Test(priority=0)
	public void verifyMyAccountPageTitle() {
		String actualTitle=accountpage.getAccountPageTitle();
		Assert.assertEquals(actualTitle, "My Account");
	}
	
	@Test(priority=1)
	public void validateSearchProduct() {
		accountpage.searchProduct("macbook");
	}
	@Test(priority=0)
	public void validateAccountHeaders() {
		List<String>expList=List.of("My Account","My Orders","My Affiliate Account","Newsletter");
		List<String> actList=accountpage.getAccountHeaderList();
		Assert.assertEquals(actList,expList);
	}
}
