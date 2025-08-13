package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Constants.AppConstants;

public class ProductInfoPage extends BasePage {
	public  WebDriver driver;
	private By selectedProdItem = By.tagName("h1");
	private By successAlertMsg = By.className("alert-success");
	private By addToCartbtn = By.id("button-cart");
	private By productDetails = By.cssSelector(".col-sm-4 ul");
	private By productQuantity = By.xpath("//*[@id='product']");
	private By shoppingCartBtn = By.partialLinkText("shopping cart");

	public ProductInfoPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	
	public boolean isItemAddSuccessAlertMsgDisplayed() {
		return webelementutiles.waitForElementVisibile(successAlertMsg,AppConstants.DEFAULT_TIMEOUT ).isDisplayed();
	}

	public void addToCart() {
		if (webelementutiles.isElementDisplayed(selectedProdItem)) {
			webelementutiles.clickOnElement(addToCartbtn);
		}
	}

	public List<String> getProductItemDetails() {
		return webelementutiles.getTextFromElements(productDetails);
	}
	
	public boolean selectedProductItemDisplayed() {
		return webelementutiles.isElementDisplayed(selectedProdItem);
	}

	public ShoppingKartPage clickOnShoppingCart() {
		WebElement successMsg = webelementutiles.waitForElementVisibile(successAlertMsg, AppConstants.DEFAULT_TIMEOUT);
		if (successMsg.getText().contains("shopping cart")) {
			webelementutiles.clickOnElement(shoppingCartBtn);
		} else {
			return null;
		}
		return new ShoppingKartPage(driver);
	}
}
