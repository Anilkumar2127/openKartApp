package com.qa.OpenKart.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

public class ShoppingKartTest extends BaseTest{
	
	
	@BeforeClass()
	public void doSetUp() {
		accountpage=loginpage.doLogin("skyfall1997@gmail.com", "Oracle123");
	
	}
	
	@Test(priority=0)
	public void validateShoppingCartHeader() {
		productsPage=accountpage.searchProduct("HP");
		productInfoPage=productsPage.clickOnResultItem("HP LP3065");
		productInfoPage.addToCart();
		shoppingKartPage=productInfoPage.clickOnShoppingCart();
		String actualheaderText=shoppingKartPage.getShoppingCartHeader();
		System.out.println(actualheaderText);
		Assert.assertEquals(true,actualheaderText.startsWith("Shopping"));
	}
	@Test
	public void clickCheckOut() {
		productsPage=accountpage.searchProduct("HP");
		productInfoPage=productsPage.clickOnResultItem("HP LP3065");
		productInfoPage.addToCart();
		shoppingKartPage=productInfoPage.clickOnShoppingCart();
		checkoutpage=shoppingKartPage.clickOnCheckOutbtn();
		Assert.assertEquals(true, checkoutpage.getCheckoutHeaderText().equalsIgnoreCase("checkout"));	
	}
}
