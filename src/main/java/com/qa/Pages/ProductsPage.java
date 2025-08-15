package com.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Constants.AppConstants;

public class ProductsPage extends BasePage {
	private final By products = By.cssSelector("div.product-thumb div h4 a");
	private final By productsHeaderText=By.tagName("h2");
	private WebDriver driver;

	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	public int getSeachProductCount() {
		return webelementutiles.getElementsCount(products);
	}

	public ProductInfoPage clickOnResultItem(String product) {
		List<WebElement> productsList = webelementutiles.getElementsVisibilityWithWait(products,AppConstants.DEFAULT_TIMEOUT);
			for (WebElement prod : productsList) {
				 String prodtext =prod.getText();
					if (prodtext.equalsIgnoreCase(product)) {
					js.scrollToElementByJavaScriptExecutor(prod);
					js.hightlightElementByJavaScriptExecutor(prod);
					prod.click();
					break;
				}
			}
		
		
		return new ProductInfoPage(driver);
	
	}
	
	public String getProductsHeaderText() {
		return webelementutiles.waitForElementVisibile(productsHeaderText, AppConstants.DEFAULT_TIMEOUT).getText();
	}

}
