package com.qa.OpenKart.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

public class ProductsTest extends BaseTest{
	
	@BeforeClass
	public void doSetUpProductTest() {
		accountpage=loginpage.doLogin("skyfall1997@gmail.com", "Oracle123");
	}
	
	@Test(priority=0)
	public void validateProductsCount() {
		productsPage=accountpage.searchProduct("mac");
		int actProductCount=productsPage.getSeachProductCount();
		System.out.println("Actual ProductCount ="+ actProductCount);
		Assert.assertEquals(actProductCount,4);
	}
	
	/*
	 * Data Provider example used to search multiple products
	 */
	@DataProvider
	public Object [][] searchMultipleProducts() {
		return new Object[][] {
			{"macbook","MacBook Pro"},
			{"samsung","Samsung SyncMaster 941BW"},
			{"samsung","Samsung Galaxy Tab 10.1"}
		};
	}

	
	@Test(priority=1,dataProvider="searchMultipleProducts")
	public void clickSearchedProductItem(String searchproductKey,String productName) {
		productsPage=accountpage.searchProduct(searchproductKey);
		productInfoPage=productsPage.clickOnResultItem(productName);
		Assert.assertEquals(true,productInfoPage.selectedProductItemDisplayed());
		
	}

}
