package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Constants.AppConstants;
import com.qa.Utilities.TimeUtiles;

public class CheckoutPage extends BasePage {
	private WebDriver driver;
	private final By permanentAddress = By.xpath("//input[@name='payment_address' and @value='new']");
	private final By billingDetailsToggle = By.cssSelector(".accordion-toggle");
	private final By checkoutHeader = By.tagName("h1");
	private final By firstName = By.name("firstname");
	private final By lastName = By.name("lastname");
	private final By address = By.name("address_1");
	private final By city = By.name("city");
	private final By postalCode = By.name("postcode");
	private final By countryCode = By.name("country_id");
	private final By state = By.name("zone_id");
	private final By billingContinueBtn = By.xpath("//*[@value='Continue']");
	private final By deliveryDetailsContinueBtn = By.id("button-shipping-address");
	private final By deliveryMethodContinueBtn = By.id("button-shipping-method");
	private final By paymentMethodContinueBtn = By.id("button-payment-method");
	private final By agreeCheckbtn = By.xpath("//*[@name='agree']");
	private final By product = By.xpath("(//td[@class='text-left']/a)[2]");
	private final By confirmOrderBtn=By.id("button-confirm");

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void fillBillingDetails(String Firstname, String Lastname, String Address, String City, String PostCode,
			String Country, String State) {

		if (webelementutiles.waitAndgetStateOfRadioBtn(permanentAddress, AppConstants.DEFAULT_TIMEOUT)) {
			// webelementutiles.clickOnElement(billingDetailsToggle);
			webelementutiles.fillTextBox(firstName, Firstname);
			webelementutiles.fillTextBox(lastName, Lastname);
			webelementutiles.fillTextBox(address, Address);
			webelementutiles.fillTextBox(city, City);
			webelementutiles.fillTextBox(postalCode, PostCode);
			webelementutiles.selectByVisibleTextFromDropDown(countryCode, Country);
			webelementutiles.selectByVisibleTextFromDropDown(state, State);
			}
		else {
			clickOnBillingContinue();
		}

	}

	public boolean permanentAddressSelected() {
		return webelementutiles.waitAndgetStateOfRadioBtn(permanentAddress, AppConstants.DEFAULT_TIMEOUT);

	}

	public void selectNewAddressRadioBtn() {
		if (!(permanentAddressSelected())) {
			webelementutiles.clickOnElement(permanentAddress);
		}
	}

	public void clickOnBillingContinue() {
		webelementutiles.waitForElementVisibile(billingContinueBtn, AppConstants.DEFAULT_TIMEOUT).click();;
	}

	public void clickOnDeliveryDetailsContinue() {
		webelementutiles.waitForElementVisibile(deliveryDetailsContinueBtn, AppConstants.DEFAULT_TIMEOUT).click();;
	}

	public void clickOnDeliveryMethodContinue() {
		webelementutiles.waitForElementVisibile(deliveryMethodContinueBtn, AppConstants.DEFAULT_TIMEOUT).click();;
	}

	public void clickOnPaymentMethodContinue() {
		webelementutiles.waitForElementVisibile(paymentMethodContinueBtn, AppConstants.DEFAULT_TIMEOUT).click();;
	}
	public  OrderSuccessPage clickOnConfirmOrderBtn() {
		webelementutiles.waitForElementVisibile(confirmOrderBtn, AppConstants.DEFAULT_TIMEOUT).click();
		return new OrderSuccessPage(driver);
	}

	public void clickAgreeCheckBox() {
		webelementutiles.waitForElementVisibile(agreeCheckbtn, AppConstants.DEFAULT_TIMEOUT).click();;
	}

	public String getConfirmedProduct() {
		return webelementutiles.waitForElementVisibile(product, AppConstants.DEFAULT_TIMEOUT).getText();
	}

	public String getCheckoutHeaderText() {
		js.hightlightElementByJavaScriptExecutor(
				webelementutiles.waitForElementVisibile(checkoutHeader, AppConstants.DEFAULT_TIMEOUT));
		return webelementutiles.getTextFromElement(checkoutHeader);
	}

}
