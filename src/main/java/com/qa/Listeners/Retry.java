//package com.qa.Listeners;
//import java.util.Properties;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;
//
//import com.qa.Factory.DriverFactory;
//
//public class Retry implements IRetryAnalyzer {
//	private WebDriver driver;
//	private int count = 0;
//	//private static int maxTry = 3;
//	
//	public Retry(WebDriver driver) {
//		this.driver=driver;
//	}
//
//	@Override
//	public boolean retry(ITestResult iTestResult) {
//		Properties prop= new DriverFactory(driver).initProp();
//		if (!iTestResult.isSuccess()) { // Check if test not succeed
//			if (count < Integer.parseInt(prop.get("retry").toString())) { // Check if maxtry count is reached
//				count++; // Increase the maxTry count by 1
//				iTestResult.setStatus(ITestResult.FAILURE); // Mark test as failed
//				return true; // Tells TestNG to re-run the test
//			} else {
//				iTestResult.setStatus(ITestResult.FAILURE); // If maxCount reached,test marked as failed
//			}
//		} else {
//			iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
//		}
//		return false;
//	}
//}