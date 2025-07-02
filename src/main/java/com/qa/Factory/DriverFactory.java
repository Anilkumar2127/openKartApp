package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.qa.Exceptions.BrowserException;

public class DriverFactory {
	protected WebDriver driver =null;
	
	public DriverFactory(WebDriver driver) {
		this.driver=driver;
	}
	
	
	/*
	 * Initialize the browser based in given browser name
	 * @paramName=browserName
	 */

	public WebDriver initDriver(String browserName) {
		System.out.println("====Browser Opening:=="+ browserName);
		switch(browserName.toLowerCase().trim()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		default :
			System.out.println("Pass the valid browser");
			throw new BrowserException("==Invalid Browser===");
		}
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
}
