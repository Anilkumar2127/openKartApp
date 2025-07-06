package com.qa.Pages;

import org.openqa.selenium.WebDriver;

import com.qa.Utilities.BrowserUtiles;
import com.qa.Utilities.ExcelUtils;
import com.qa.Utilities.WaitUtiles;
import com.qa.Utilities.WebElementUtiles;

public class BasePage {

	public WebElementUtiles webelementutiles;
	public BrowserUtiles browserutiles;
	public WaitUtiles waitutilities;
	public ExcelUtils excelutils;
	
	public BasePage(WebDriver driver) {
		webelementutiles=new WebElementUtiles(driver);	
		browserutiles=new BrowserUtiles(driver);
		waitutilities=new WaitUtiles(driver);
		excelutils=new ExcelUtils(driver);
	}
	

}
