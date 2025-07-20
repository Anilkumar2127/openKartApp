	package com.qa.Utilities;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Exceptions.BrowserException;

public class BrowserUtiles {
	
	private WebDriver driver;
	
	public BrowserUtiles(WebDriver driver) {
		this.driver=driver;
	}
	/*
	 * Checks if Url is empty throw and exception
	 */
	private void urlLengthCheck(String url) {
		if (url.length() == 0) {
			System.out.println("****Plz pass the Proper Url****" + url);
			throw new BrowserException("===Url is Empty ===");
		}
	}
	/*
	 * Checks if Url doesn't starts with https or http
	 */
	private void httpProtocolCheck(String url) {
		if (url.indexOf("http") != 0) {// Check point to verify the url having http or https at starting point
			System.out.println("***Plz pass with proper https or http protocol url***" + url);
			throw new BrowserException("===Url should have HTTP or HTTPS==");
		}
	}
	/*
	 * Launching the testurl with string url
	 */
	public void launchUrl(String testUrl) {
		urlLengthCheck(testUrl);
		httpProtocolCheck(testUrl);
		driver.get(testUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	/*
	 * Launching the testUrl with Url type url
	 */
	public void launchUrl(URL Url) {
		String testUrl = String.valueOf(Url);//Conversion from one data type to String.
		urlLengthCheck(testUrl);
		httpProtocolCheck(testUrl);
		driver.get(testUrl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	/*
	 * Getting Current url from the Browser
	 */
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	/*
	 * Quiting the Browser
	 */
	public void quitBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}
	/*
	 * Closing the Browser
	 */
	public void closeBrowser() {
		if(driver!=null) {
			driver.close();
		}
	}
	/*
	 * Verifies whether page is loaded or not
	 */
	public boolean isPageLoaded(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		String flag=wait.until(ExpectedConditions.jsReturnsValue("return document.readyState=== 'complete'")).toString();
		return Boolean.parseBoolean(flag);
	}
}
