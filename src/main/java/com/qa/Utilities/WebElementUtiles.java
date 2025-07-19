package com.qa.Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import com.qa.Exceptions.ElementExceptions;

public class WebElementUtiles {
	private WebDriver driver;
	private Actions act = null;

	private void nullcheck(CharSequence... value) {// CharSequence is an interface but implements by
													// stringbuilder,stringbuffer and string classes
		if (value == null) {
			throw new ElementExceptions("==Please dont pass Null, pass charsequence value==");
		}
	}

	public WebElementUtiles(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	/****************************
	 * WebElement based on string
	 ****************************/

	public By getBy(String locatorType, String valueLocator) {
		By locator = null;
		switch (locatorType.toLowerCase().trim()) {
		case "id":
			locator = By.id(valueLocator);
			break;
		case "name":
			locator = By.name(valueLocator);
			break;
		case "tag":
			locator = By.tagName(valueLocator);
			break;
		case "css":
			locator = By.cssSelector(valueLocator);
			break;
		case "classname":
			locator = By.className(valueLocator);
			break;
		case "linktext":
			locator = By.linkText(valueLocator);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(valueLocator);
			break;
		case "xpath":
			locator = By.xpath(valueLocator);
			break;
		default:
			System.out.println("plz pass the right locator type: " + locatorType);
			break;
		}
		return locator;
	}

	public WebElement getElementLocator(String locatorType, String locatorValue) {
		return driver.findElement(getBy(locatorType, locatorValue));
	}

	/******************************
	 * WebElement to get Element
	 ******************************/

	public WebElement getElementLocator(By locator) {
		return driver.findElement(locator);
	}

	/********************************
	 * WebElments to getElements
	 ********************************/
	/*
	 * Description:It returns multiple element locators
	 * 
	 * @Params:Expecting locator
	 */
	public List<WebElement> getElementLocators(By locator) {
		return driver.findElements(locator);
	}

	/*
	 * Description:It returns total count of elements
	 * 
	 * @Params:Expecting locator
	 */
	public int getElementsCount(By locator) {
		int size = getElementLocators(locator).size();
		return size;
	}

	/*
	 * Description:It returns list of text contents from multiple elements
	 * 
	 * @Params:Expecting locator
	 */
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

	/*
	 * Description: Returns boolean value if only one element is displayed on AUT
	 * 
	 * @param:locators
	 */
	public boolean checkElementDisplayed(By locator) {
		if (getElementLocators(locator).size() == 1) {
			return true;
		}
		return false;
	}

	/*
	 * Description: Returns boolean value if you expected elements count is
	 * displayed on AUT
	 * 
	 * @param:locators, total expected elements count.
	 * 
	 */
	public boolean checkElementDisplayed(By locator, int expectedElementCount) {
		if (getElementLocators(locator).size() == expectedElementCount) {
			return true;
		}
		return false;
	}

	/*
	 * Description:Clicks on specific element from multiple locators by passing
	 * expectedValue
	 * 
	 * @param:By locator and ecpectedElementtext to be clicked
	 */
	public void clickOnSpecificElement(By locator, String expValue) {
		List<WebElement> listofElementslocators = getElementLocators(locator);
		for (WebElement ele : listofElementslocators) {
			String textvalue = ele.getText();
			if (textvalue.contains(expValue)) {
				ele.click();
				break;
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////
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
		} catch (NoSuchElementException e) {
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
	////////////////////////////////////////////////////////////////////////////
	////////////// SELECT KIND DROP DOWN ELEMENTUTILS///////////////////////////
	////////////////////////////////////////////////////////////////////////////

	/*
	 * Selecting the element from drop down based on dropdown text
	 * 
	 * @param:By locator,String text
	 */
	public boolean selectByVisibleTextFromDropDown(By locator, String value) {
		Select dropDown = new Select(getElementLocator(locator));
		try {// NoSuchElementException arises due text value is not present in drop down
			dropDown.selectByVisibleText(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Text not present in drop down " + value);
			return false;
		}
	}

	/*
	 * Selecting the element from drop down based on dropdown value
	 * 
	 * @param:By locator,String value
	 */
	public boolean selectByValueFromDropDown(By locator, String value) {
		Select dropDown = new Select(getElementLocator(locator));
		try {
			dropDown.selectByValue(value);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Value not present in dropdown " + value);
			return false;
		}
	}

	/*
	 * Selecting the element from drop down based on dropdown index
	 * 
	 * @param:By locator,String index
	 */
	public boolean selectByIndexFromDropDown(By locator, int index) {
		Select dropDown = new Select(getElementLocator(locator));
		try {
			dropDown.selectByIndex(index);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("No index is selected from dropdown " + index);

			return false;
		}
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////// RELATIVE LOCATOR INTRO AFTER
	////////////////////////////////////////////////////////////////////////////////////////// 4.x//////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	public String getLeftElementTextFromBaseLocator(By targetLocator, By referenceLocator) {
		return driver.findElement(RelativeLocator.with(targetLocator).toLeftOf(referenceLocator)).getText();
	}

	public String getRightElementTextFromBaseLocator(By targetLocator, By referenceLocator) {
		return driver.findElement(RelativeLocator.with(targetLocator).toLeftOf(referenceLocator)).getText();
	}

	public String getNearByElementTextFromBaseLocator(By targetLocator, By referenceLocator) {
		return driver.findElement(RelativeLocator.with(targetLocator).near(referenceLocator)).getText();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////// Drop Down WithOut Select
	////////////////////////////////////////////////////////////////////////////////////////////// tag////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * Description: Selecting the drop down values based on condition
	 * 
	 * @choiceField :Provide the dropdown field locator to click
	 * 
	 * @choicesList :Provide the Lists locators from the drop down field
	 * 
	 * @choicesvalue:Give the values to select the choices i.e to select all give as
	 * "all"
	 * 
	 */
	public void selectChoice(By choiceField, By choicesList, String... choicesvalue) {
		clickOnElement(choiceField);
		List<WebElement> choicesLists = getElementLocators(choicesList);
		if (choicesvalue[0].trim().equalsIgnoreCase("all")) {
			for (WebElement ele : choicesLists) {
				ele.click();
			}
		} else {
			for (WebElement ele : choicesLists) {
				String choiceText = ele.getText();
				for (String selChoice : choicesvalue) {
					if (choiceText.equalsIgnoreCase(selChoice)) {
						ele.click();
						break;
					}
				}
			}
		}

	}

	/*
	 * //////////////////////Actions class elements///////////////////////////////////////////
	 */
	
	public void doActionClick(By locator) {
		act.click(getElementLocator(locator)).build().perform();
	}

	public void doSendKeysAction(By locator,String value) {
		act.sendKeys(value).build().perform();
	}
	/*		INTERVIEW QUESTION
	 * Entering the string value one by one in text field using Actions class
	 * @Params=Locator
	 * @Params=Value to enter
	 * @Params=Pause time 
	 */
	public void doSendKeysWithPause(By locator,String value,int pauseTime) {
		char val[]=value.toCharArray();
		for(char v:val) {
			act.sendKeys(getElementLocator(locator), String.valueOf(v))
				.pause(pauseTime)
					.build().perform();
		}
	}
}
//////////////////////////////////////////////////////////////////////////////////////////////


	