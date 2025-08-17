package com.qa.OpenKart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.Factory.DriverFactory;
import com.qa.Pages.AcccountPage;
import com.qa.Pages.AccountRegisterPage;
import com.qa.Pages.CheckoutPage;
import com.qa.Pages.LoginPage;
import com.qa.Pages.OrderSuccessPage;
import com.qa.Pages.ProductInfoPage;
import com.qa.Pages.ProductsPage;
import com.qa.Pages.ShoppingKartPage;
import com.qa.Utilities.BrowserUtiles;

public class BaseTest {

	private WebDriver driver=null;
	public BrowserUtiles browutiles=null;
	private DriverFactory df;
	Properties prop;
	protected LoginPage loginpage;//access its value outside the package , but non subclass will not work ,subclass will work
	protected AcccountPage accountpage;
	protected AccountRegisterPage accregpage;
	protected ProductsPage productsPage;
	protected ProductInfoPage productInfoPage;
	protected ShoppingKartPage shoppingKartPage;
	protected CheckoutPage checkoutpage;
	protected OrderSuccessPage ordersuccesspage;
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browserName) {
		df=new DriverFactory(driver);
		Properties prop=df.initProp();
		/*
		 * Getting Browser value from the TestNG.xml files
		 */
		if(browserName!=null) {
			prop.setProperty("browser", browserName);
		}
		
		driver=df.initDriver(prop);
		browutiles =new BrowserUtiles(driver);
		browutiles.launchUrl(prop.getProperty("Baseurl"));
		loginpage=new LoginPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		browutiles.quitBrowser();
	}
}
