package com.qa.OpenKart.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.Factory.DriverFactory;
import com.qa.Pages.LoginPage;

public class BaseTest {

	public WebDriver driver;
	DriverFactory df;
	protected LoginPage loginpage; //access its value outside the package , but non subclass will not work ,subclass will work
	
	@BeforeTest
	public void setUp() {
		df=new DriverFactory(driver);
		driver=df.initDriver("chrome");
		loginpage=new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
