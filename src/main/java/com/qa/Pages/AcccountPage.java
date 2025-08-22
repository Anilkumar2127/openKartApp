package com.qa.Pages;

import static com.qa.Constants.AppConstants.DEFAULT_TIMEOUT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AcccountPage extends BasePage {
	
	private WebDriver driver=null;
	private final By search=By.name("search");
	private final By searchbtn=By.className("btn-default");
	private final By acctHeader=By.tagName("h2");
	
	public AcccountPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public String getAccountPageTitle() {
		String title = webelementutiles.waitForPageTitleIs("My Account",DEFAULT_TIMEOUT);//Static constant import
		return title;
	}
	public ProductsPage searchProduct(String productName) {
		webelementutiles.waitForElementVisibile(search, DEFAULT_TIMEOUT);
		webelementutiles.fillTextBox(search, productName);
		js.drawBorderElementByJavaScriptExecute(webelementutiles.getElementLocator(searchbtn));
		webelementutiles.clickOnElement(searchbtn);
		return new ProductsPage(driver);
	}
	
	public List<String> getAccountHeaderList() {
		return webelementutiles.getTextFromElements(acctHeader);
	}
}
