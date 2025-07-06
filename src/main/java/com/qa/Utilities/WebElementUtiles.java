package com.qa.Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Exceptions.ElementExceptions;

public class WebElementUtiles {
	private WebDriver driver;

	private void nullcheck(CharSequence... value) {// CharSequence is an interface but implements by
													// stringbuilder,stringbuffer and string classes
		if (value == null) {
			throw new ElementExceptions("==Please dont pass Null, pass charsequence value==");
		}
	}

	public WebElementUtiles(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getElementLocator(By locator) {
		return driver.findElement(locator);
	}

	/*******************************
	 * WebLements to getElements
	 ********************************/
	public List<WebElement> getElementLocators(By locator) {
		return driver.findElements(locator);
	}

	public int getElementCount(By locator) {
		int size = getElementLocators(locator).size();
		return size;
	}

	public List<String> getTextFromElements(By locator) {
		List<WebElement> listOfElements = getElementLocators(locator);
		List<String> textList = new ArrayList<String>();
		for (WebElement e : listOfElements) {
			String text = e.getText();
			if (text.length() != 0) {
				System.out.println("actual elements Text ==> " + text);
				textList.add(text);
			}
		}
		return textList;
	}

	////////////////////////////////////////////////////////////////////////////////
	public void fillTextBox(By locator, String value) {
		nullcheck(value);
		getElementLocator(locator).sendKeys(value);
	}

	public void fillTextBox(By locator, CharSequence... value) {
		nullcheck(value);
		getElementLocator(locator).sendKeys(value);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			if (getElementLocator(locator).isDisplayed()) {
				return true;
			}
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
			System.out.println("=== element Not found ===");
		}	
		return false;
	}

	public void clickOnElement(By locator) {
		getElementLocator(locator).click();
	}

	public String getTextFromElement(By locator) {
		return getElementLocator(locator).getText();
	}

	public String getElmentDomAttributeValue(By locator, String attributeName) {
		return getElementLocator(locator).getDomAttribute(attributeName);
	}

	public String getElmentDomPropertyValue(By locator, String propertyName) {
		return getElementLocator(locator).getDomProperty(propertyName);
	}

}
