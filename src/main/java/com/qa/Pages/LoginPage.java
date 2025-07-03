package com.qa.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
	// private Locators
	private final By forgotPassword = By.partialLinkText("Forgotten Password");
	private final By userName = By.id("input-email");
	private final By passWord = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@type='submit']");
	private final By myAccount = By.partialLinkText("My Account");


	// public constructor
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	// page Methods
	public String getLoginPageTile() {
		String title = webelementutiles.getPageTitle();
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

	public String doLogin(String username, String password) throws InterruptedException {
		webelementutiles.fillTextBox(userName,username);
		webelementutiles.fillTextBox(passWord,password);
		webelementutiles.clickOnElement(loginBtn);
		/*WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(myAccount));*/
		Thread.sleep(3000);
		return webelementutiles.getPageTitle();
	}

}
