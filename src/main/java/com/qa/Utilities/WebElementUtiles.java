package com.qa.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WebElementUtiles {
	private WebDriver driver;
	private WaitUtiles waitUtiles;
	
	public WebElementUtiles(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public WebElement elementLocator(By locator) {
		return driver.findElement(locator);
	}
	
	public  void fillTextBox (By locator,String value) {
		 elementLocator(locator).sendKeys(value);
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isElementDisplayed(By locator) {
		if(elementLocator(locator).isDisplayed()) {
			return true;
		}
		else return false;
	}
	
	public void clickOnElement(By locator) {
		elementLocator(locator).click();;
	}
	
	public void waitAndClick(By locator,int timeOutInSeconds) {
		this.waitUtiles.waitForElementVisible(locator,timeOutInSeconds);
		elementLocator(locator).click();
		
	}
	
}
