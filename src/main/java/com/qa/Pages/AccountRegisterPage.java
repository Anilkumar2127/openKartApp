package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Constants.AppConstants;
import com.qa.Utilities.StringUtiles;

public class AccountRegisterPage extends BasePage {
	
	private WebDriver driver;
	private final By firstName=By.name("firstname");
	private final By lastName=By.name("lastname");
	private final By emailAddress=By.name("email");
	private final By telephone=By.name("telephone");
	private final By password=By.name("password");
	private final By confirmPassword=By.name("confirm");
	private final By newsletterSubscribeYes=By.xpath("(//input[@name='newsletter'])[1]");
	private final By newsletterSubscribeNo=By.xpath("(//input[@name='newsletter'])[2]");
	private final By agree=By.xpath("//*[@name='agree']");
	private final By submitbtn=By.xpath("//*[@type='submit']");
	private final By successHeader=By.tagName("h1");
	private final By logOut=By.partialLinkText("Logout");
	private final By registerbtn=By.partialLinkText("Register");
	
	public AccountRegisterPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	public boolean doUserRegister(String firstname,String lastname,String telephone,String password,
			String subscribe) {	
		js.hightlightElementByJavaScriptExecutor(webelementutiles.getElementLocator(firstName));
		webelementutiles.waitForElementVisibile(firstName,AppConstants.DEFAULT_TIMEOUT).sendKeys(firstname);
		webelementutiles.waitForElementVisibile(lastName,AppConstants.DEFAULT_TIMEOUT).sendKeys(lastname);
		webelementutiles.waitForElementVisibile(emailAddress,AppConstants.DEFAULT_TIMEOUT).sendKeys(StringUtiles.getDummyEmailAddress());
		webelementutiles.waitForElementVisibile(this.telephone,AppConstants.DEFAULT_TIMEOUT).sendKeys(telephone);
		webelementutiles.waitForElementVisibile(this.password,AppConstants.DEFAULT_TIMEOUT).sendKeys(password);
		webelementutiles.waitForElementVisibile(confirmPassword,AppConstants.DEFAULT_TIMEOUT).sendKeys(password);
		if(subscribe.equalsIgnoreCase("yes")) {
			webelementutiles.clickOnElement(newsletterSubscribeYes);
		}else {
			webelementutiles.clickOnElement(newsletterSubscribeNo);
		}
		webelementutiles.doActionClick(agree);
		webelementutiles.doActionClick(submitbtn);
		
		if(webelementutiles.waitForElementVisibile(successHeader,AppConstants.DEFAULT_TIMEOUT).getText().contains("Your Account Has Been Created")) {
			webelementutiles.doActionClick(logOut);
			webelementutiles.doActionClick(registerbtn);
			return true;
		}
		return false;
	}
}

