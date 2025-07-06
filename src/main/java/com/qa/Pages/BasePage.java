package com.qa.Pages;

import org.openqa.selenium.WebDriver;

import com.qa.Utilities.BrowserUtiles;
import com.qa.Utilities.WebElementUtiles;

public class BasePage {

	public WebElementUtiles webelementutiles;
	public BrowserUtiles browserutiles;
	
	public BasePage(WebDriver driver) {
		webelementutiles=new WebElementUtiles(driver);	
		browserutiles=new BrowserUtiles(driver);	
	}
	

}
