package com.qa.OpenKart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;
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
import com.qa.Utilities.LoggerUtiles;

//@Listeners(ChainTestListener.class)
public class BaseTest {

	private WebDriver driver = null;
	public BrowserUtiles browutiles = null;
	private DriverFactory df;
	Properties prop;
	protected LoginPage loginpage;// access its value outside the package , but non subclass will not work
									// ,subclass will work
	protected AcccountPage accountpage;
	protected AccountRegisterPage accregpage;
	protected ProductsPage productsPage;
	protected ProductInfoPage productInfoPage;
	protected ShoppingKartPage shoppingKartPage;
	protected CheckoutPage checkoutpage;
	protected OrderSuccessPage ordersuccesspage;

	@Parameters({ "browser" })
	@BeforeTest
	public void setUp(String browserName) {
		df = new DriverFactory(driver);
		Properties prop = df.initProp();
		/*
		 * Getting Browser value from the TestNG.xml files
		 */
		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}
		driver = df.initDriver(prop);
		browutiles = new BrowserUtiles(driver);
		//System.out.println("--=-=-"+prop.getProperty("Baseurl"));
		browutiles.launchUrl(prop.getProperty("Baseurl"));
		loginpage = new LoginPage(driver);

	}

	@BeforeMethod
	public void loggingBeforeTests(ITestResult result) {
		LoggerUtiles.info("---------STARTED TESTCASE-----------------:"+result.getMethod().getMethodName());
	}
	@AfterMethod
	public void attachScreenShotInReport(ITestResult result) {
		if(!(result.isSuccess())) {
			LoggerUtiles.info("-----------Failed And Taking ScreenShot----------------------");
			 ChainTestListener.embed(DriverFactory.takeScreenShot(),"image/png");
		}
		LoggerUtiles.info("----------Ended Test Case------------------:"+result.getMethod().getMethodName());
		if(result.isSuccess()) {
			LoggerUtiles.info("-----------Passed----------------------");
		}
		
	}

	@AfterTest
	public void tearDown() {
		browutiles.quitBrowser();
	}
}
