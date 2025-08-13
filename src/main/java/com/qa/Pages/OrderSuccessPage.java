package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Constants.AppConstants;

public class OrderSuccessPage extends BasePage {
	
	public WebDriver driver;
	private By successHeader=By.tagName("h1");
	private By successContinueBtn=By.partialLinkText("Continue");
	
	public OrderSuccessPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public String getSuccessHeaderText() {
		return webelementutiles.waitForElementVisibile(successHeader, AppConstants.DEFAULT_TIMEOUT).getText();
	}
	
	public String getSuccessUrl() {
		return webelementutiles.waitForUrlContains("success", AppConstants.DEFAULT_TIMEOUT);
	}
	public void clickOnContinueBtn() {
		webelementutiles.clickOnElement(successContinueBtn);
	}
}
