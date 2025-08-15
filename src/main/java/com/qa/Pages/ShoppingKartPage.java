package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Constants.AppConstants;
import com.qa.Utilities.TimeUtiles;


public class ShoppingKartPage extends BasePage {

	private WebDriver driver;
	private final By checkoutbtn=By.partialLinkText("Checkout");
	private final By shoppingHeader=By.tagName("h1");
	public ShoppingKartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public CheckoutPage clickOnCheckOutbtn() {
			js.scrollPageDownByJavaScriptExecutor();
			webelementutiles.clickOnElement(checkoutbtn);
			return new CheckoutPage(driver);
	}
	public String getShoppingCartHeader() {
		return webelementutiles.waitForElementVisibile(shoppingHeader,AppConstants.DEFAULT_TIMEOUT).getText();
	}
}
