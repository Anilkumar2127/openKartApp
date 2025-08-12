package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	private By billingDetailsToggle=By.cssSelector(".accordion-toggle");
	private By firstName=By.name("firstname");
	private By lastName=By.name("lastname");
	private By address=By.name("address_1");
	private By city=By.name("city");
	private By postalCode=By.name("postcode");
	private By countryCode=By.name("country_id");
	private By zone=By.name("zone_id");
	private By continueBtn=By.xpath("//*[@value='Continue']");
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
}
