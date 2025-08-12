package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Constants.AppConstants;


public class ShoppingKartPage extends BasePage {

	protected WebDriver driver;
	private By checkoutbtn=By.partialLinkText("Checkout");
	private By shoppingHeader=By.tagName("h1");
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
