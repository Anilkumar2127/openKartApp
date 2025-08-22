package com.qa.Pages;

import org.openqa.selenium.WebDriver;

//import com.qa.Listeners.Retry;
import com.qa.Utilities.BrowserUtiles;
import com.qa.Utilities.JavaScriptExecutor;
import com.qa.Utilities.WebElementUtiles;

public class BasePage {

	public WebElementUtiles webelementutiles;
	public BrowserUtiles browserutiles;
	public JavaScriptExecutor js;
	//public Retry retry;
	public BasePage(WebDriver driver) {
		webelementutiles=new WebElementUtiles(driver);	
		browserutiles=new BrowserUtiles(driver);	
		js=new JavaScriptExecutor(driver);
		//retry=new Retry(driver);
		
	}
	

}
