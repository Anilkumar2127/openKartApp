package com.qa.OpenKart.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

public class ShoppingKartTest extends BaseTest{
	
	
	@BeforeClass()
	public void doSetUp() {
		accountpage=loginpage.doLogin("skyfall1997@gmail.com", "Oracle123");
		productsPage=accountpage.searchProduct("HP");
		productInfoPage=productsPage.clickOnResultItem("HP LP3065");
		productInfoPage.addToCart();
		shoppingKartPage=productInfoPage.clickOnShoppingCart();
	}
	
	@Test
	public void validateShoppingCartHeader() {
		String actualheaderText=shoppingKartPage.getShoppingCartHeader();
		Assert.assertEquals(true,actualheaderText.startsWith("Shopping"));
	}
	
	public void clickCheckOut() {
		shoppingKartPage.clickOnCheckOutbtn();
	}
}
