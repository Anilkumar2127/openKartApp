package com.qa.OpenKart.testCases;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

public class ProductInfoTest extends BaseTest{
	@BeforeClass
	public void doSetUp() {
		accountpage=loginpage.doLogin("skyfall1997@gmail.com", "Oracle123");
		
		
	}
	
	@Test(priority=1)
	public void addItemNotification() {
		productsPage=accountpage.searchProduct("HP");
		productInfoPage=productsPage.clickOnResultItem("HP LP3065");
		productInfoPage.addToCart();
		Assert.assertEquals(true,productInfoPage.isItemAddSuccessAlertMsgDisplayed());	
	}
	@Test(priority=2)	
	public void addItemInCart() {
		productsPage=accountpage.searchProduct("HP");
		productInfoPage=productsPage.clickOnResultItem("HP LP3065");
		productInfoPage.addToCart();
		shoppingKartPage=productInfoPage.clickOnShoppingCart();
		boolean actValue=shoppingKartPage.getShoppingCartHeader().contains("Shopping");
		Assert.assertEquals(actValue,true);
	}
	@Test(priority=0)
	public void validateAddedItemDetails() {
		productsPage=accountpage.searchProduct("HP");
		productInfoPage=productsPage.clickOnResultItem("HP LP3065");
		List<String>expectedItemDetails;
		List<String>actualItemDetails=productInfoPage.getProductItemDetails();
		expectedItemDetails=actualItemDetails;
		System.out.println(expectedItemDetails);
		Assert.assertEquals(actualItemDetails.get(0),expectedItemDetails.get(0));
	}
	
}
