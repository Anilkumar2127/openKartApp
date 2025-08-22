package com.qa.OpenKart.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

public class CheckoutTest extends BaseTest{
	
	
	@BeforeClass
	public void doSetUp(){
		accountpage=loginpage.doLogin("skyfall1997@gmail.com","Oracle123");

	}
	
	@Test
	public void enterBillDetails() {
		productsPage=accountpage.searchProduct("HP");
		productInfoPage=productsPage.clickOnResultItem("HP LP3065");
		productInfoPage.addToCart();
		shoppingKartPage=productInfoPage.clickOnShoppingCart();
		checkoutpage=shoppingKartPage.clickOnCheckOutbtn();
		checkoutpage.fillBillingDetails("anil", "kumar", "nampally", "hyder", "53007","India","Goa");
		checkoutpage.clickOnDeliveryDetailsContinue();
		checkoutpage.clickOnDeliveryMethodContinue();
		checkoutpage.clickAgreeCheckBox();
		checkoutpage.clickOnPaymentMethodContinue();
		Assert.assertEquals(checkoutpage.getConfirmedProduct(),"HP LP3065");
		
	}
}
