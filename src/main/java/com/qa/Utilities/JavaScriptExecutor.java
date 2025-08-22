package com.qa.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

	private WebDriver driver;
	private JavascriptExecutor js;

	public JavaScriptExecutor(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) this.driver;
	}

	private void changeColor(String color, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor ='" + color + "'", ele);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getTitleByJavaScriptExecutor() {
		return js.executeScript("return document.title").toString();
	}

	public String getUrlByJavaScriptExecutor() {
		return js.executeScript("return document.url").toString();
	}

	public void navigatebackByJavaScriptExecutor() {
		js.executeScript("history.go(-1)");
	}

	public void navigateForwardByJavaScriptExecutor() {
		js.executeScript("history.go(1)");
	}

	public void refreshBrowserByJavaScriptExecutor() {
		js.executeScript("history.go(0)");
	}

	public String getInnerTextByjavaScriptExecutor() {// Usecase : To capture full page test .
		return js.executeScript("return document.documentElement.innerText").toString();
	}

	public void scrollPageDownByJavaScriptExecutor() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}

	public void scrollPageUpByJavaScriptExecutor() {
		js.executeScript("window.scrollTo(0,0");
	}

	public void scrollToElementByJavaScriptExecutor(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	public void drawBorderElementByJavaScriptExecute(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}

	public void hightlightElementByJavaScriptExecutor(WebElement element) {
		String bgColor = element.getCssValue("background-color");
		String wishColor = "rgb(255, 255, 0)";//yellow
		for (int i = 0; i <5; i++) {
			changeColor(wishColor, element);
			changeColor(bgColor, element);
		}
	}

	public void zoomInPageByJavaScriptExecutorInChromeEdge(String zoomPercentage)// responsive testing
	{
		String zoom="document.body.style.zoom='" + zoomPercentage + "'" + "%";
		js.executeScript(zoom);
	}
	
	public void zoomOutPageByJavaScriptExecutorInFireFox(String zoomPercentage) {
		String zoom="document.body.style.MozTransform='" + zoomPercentage + "'" + "%";
		js.executeScript(zoom);
	}
	
	public void clickOnElementByJavaScriptExecutor(WebElement element) {//Last option if nothing works with webelement,action click then only applicable
		js.executeScript("arguments[0].click();",element);
	}

}
