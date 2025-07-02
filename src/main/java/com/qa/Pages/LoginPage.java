package com.qa.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	// private Locators
	private final By forgotPassword = By.partialLinkText("Forgotten Password");
	private final By userName = By.id("input-email");
	private final By passWord = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@type='submit']");
	private final By myAccount = By.partialLinkText("My Account");
	private WebDriver driver;

	// public constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// page Methods
	public String getLoginPageTile() {
		String title = driver.getTitle();
		System.out.println("The title is :" + title);
		return title;
	}

	public String getCurrentLoginPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("The Current Url is :" + url);
		return url;
	}

	public boolean isForgotPasswordExist() {
		return driver.findElement(forgotPassword).isDisplayed();
	}

	public String doLogin(String username, String password) {
		driver.findElement(userName).sendKeys(username);
		driver.findElement(passWord).sendKeys(password);
		driver.findElement(loginBtn).click();
		System.out.println(driver.getTitle());
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));
		return driver.getTitle();
	}

}
