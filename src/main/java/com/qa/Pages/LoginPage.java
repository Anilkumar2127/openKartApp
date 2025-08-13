package com.qa.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.Constants.AppConstants.*;
import com.qa.Utilities.TimeUtiles;
import com.qa.Utilities.*;


public class LoginPage extends BasePage {
	// private Locators
	private final By forgotPassword = By.partialLinkText("Forgotten Password");
	private final By userName = By.id("input-email");
	private final By passWord = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@type='submit']");
	private final By appServices=By.cssSelector(".list-group a");
	private final By myAccount = By.partialLinkText("My Account");
	private final By referenceLocatorFromwebTable=By.xpath("//*[text()='Admin']");
	private final By targetLocatorFromWebTable=By.tagName("a");
	public WebDriver driver;

	// public constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;

	}

	// page Methods
	public String getLoginPageTitle() {
		String title = webelementutiles.waitForPageTitleIs("Account Login",DEFAULT_TIMEOUT);//Static constant import
		System.out.println("The title is :" + title);
		return title;
	}

	public String getCurrentLoginPageUrl() {
		String url = browserutiles.getCurrentPageUrl();
		System.out.println("The Current Url is :" + url);
		return url;
	}

	public boolean isForgotPasswordExist() {
		return webelementutiles.isElementDisplayed(forgotPassword);
	}
	
	public void clickElementInAppServicesList(String expvalue) {
		webelementutiles.clickOnSpecificElement(appServices,expvalue.toLowerCase().trim());
	}

	public AcccountPage doLogin(String username, String password) {
		webelementutiles.waitForElementVisibile(userName, DEFAULT_TIMEOUT).sendKeys(username);
		webelementutiles.fillTextBox(passWord,password);
		webelementutiles.clickOnElement(loginBtn);
		return new AcccountPage(driver);
	}

	

}
