package com.qa.OpenKart.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.OpenKart.base.BaseTest;

public class ProductsTest extends BaseTest{
	
	@BeforeClass
	public void doSetUpProductTest() {
		accountpage=loginpage.doLogin("skyfall1997@gmail.com", "Oracle123");
	}
	
	@Test(priority=0)
	public void validateProductsCount() {
		productsPage=accountpage.searchProduct("HP");
		int actProductCount=productsPage.getSeachProductCount();
		System.out.println("Actual ProductCount ="+ actProductCount);
		Assert.assertEquals(actProductCount,1);
	}
	
	
	@Test(priority=1)
	public void clickSearchedProductItem() {
		String expProduct="HP LP3065";
		//productsPage=accountpage.searchProduct("mac");
		productsPage.clickOnResultItem(expProduct);
	}

}
