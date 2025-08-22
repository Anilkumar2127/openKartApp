package com.qa.Utilities;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtiles {

	private WebDriver driver;
	private WebDriverWait wait;
	private Wait<WebDriver> waitf;

	public WaitUtiles(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * Description:Wait for element to be visible and return the webelement
	 * 
	 * @param locator and timeOutInSeconds Pass in seconds
	 * @param send    timeout in seconds
	 * @return single webelement matched with the locator else return null value
	 * 
	 */
	public WebElement waitForElementVisible(By locator, int timeOutInSeconds) {
		try {
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			System.out.println("Timeout: Element is not visible." + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * Description:Wait for list of Webelements to be visible and return the
	 * List<WebElement>
	 * 
	 * @param locator and timeOutInSeconds Pass in seconds
	 * @return list of webelements matched with the locator else return emptylist
	 */

	public List<WebElement> waitForAllElementsVisible(By locator, int timeOutInSeconds) {
		try {
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		} catch (TimeoutException e) {
			System.out.println("Timeout: Elements are not visible." + e.getMessage());
			e.printStackTrace();
			return Collections.emptyList();
		}

	}

	/**
	 * Description:Wait for the element to be clickable
	 * 
	 * @param locator and timeOutInSeconds Pass in seconds
	 * @return return the webelement
	 */

	public WebElement waitForElementToBeClickable(By locator, int timeOutInSeconds) {
		try {
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (TimeoutException e) {
			System.out.println("Timeout: Element not clickable." + e.getMessage());
		} catch (ElementClickInterceptedException e) {
			System.out.println("Click was intercepted by another element." + e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable even though it was found." + e.getMessage());
		}
		return null;
	}

	/**
	 * Description:it will wait for alert within specified time
	 * 
	 * @param timeOutInSeconds Pass time in seconds
	 * @return alert if alert is present within the timeout else return null value
	 */
	public Alert waitForAlertIsPresent(int timeOutInSeconds) {
		try {
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
			return wait.until(ExpectedConditions.alertIsPresent());
		} catch (TimeoutException e) {
			System.out.println("Timeout: Alert is not present." + e.getMessage());
			return null;
		}
	}

	/**
	 * 
	 * @param locator
	 * @param timeOutInSeconds
	 * @return webelement if element is present in DOM else will throw an timeout
	 *         exception
	 */
	public WebElement waitForElementPresent(By locator, int timeOutInSeconds) { //This em
		try {
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			System.out.println("Timeout: Element is not present in DOM." + e.getMessage());
			return null;
		}
	}

	public WebElement waitForElementVisible(By locator, int timeOutInSeconds, int pollingInSeconds) {
		try {
			this.waitf = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
					.pollingEvery(Duration.ofSeconds(pollingInSeconds)).ignoring(NoSuchElementException.class)
					.ignoring(ElementNotInteractableException.class);

			return wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					WebElement element = driver.findElement(locator);
					if (element.isDisplayed() && element.isEnabled()) {
						return element;
					} else {
						return null;
					}
				}
			});
		} catch (Exception e) {
			System.out.println("Timeout: Element is not visible." + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}

	public List<WebElement> waitForAllElementsVisible(By locator, int timeOutInSeconds, int pollingInSeconds) {
		try {
			this.waitf = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeOutInSeconds))
					.pollingEvery(Duration.ofSeconds(pollingInSeconds)).ignoring(NoSuchElementException.class)
					.ignoring(ElementNotInteractableException.class);

			return wait.until(new Function<WebDriver, List<WebElement>>() {
				public List<WebElement> apply(WebDriver driver) {
					List<WebElement> elements = driver.findElements(locator);
					if (elements.isEmpty()) {
						return Collections.emptyList();
					}
					for (WebElement element : elements)
						if (!element.isDisplayed() || !element.isEnabled()) {
							return null;
						}
					return elements;
				}
			});
		} catch (Exception e) {
			System.out.println("Timeout: Elements are not visible." + e.getMessage());
			e.printStackTrace();
			return null;
		}

	}
}
