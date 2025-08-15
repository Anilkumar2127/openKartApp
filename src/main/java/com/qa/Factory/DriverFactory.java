package com.qa.Factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Exceptions.BrowserException;
/*
 * Properties Files initialization
 * Driver initialization
 */
public class DriverFactory {
	protected WebDriver driver = null;
	Properties prop=null;

	public DriverFactory(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Initialize the browser based on given browser name
	 * 
	 * @paramName=browserName
	 */
	public WebDriver initDriver(Properties prop) {
		String browserName=prop.getProperty("browser");
		System.out.println("====Browser Opening:==" + browserName);
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Pass the valid browser");
			throw new BrowserException("===Invalid Browser===");
		}
		return driver;
	}
	
	public Properties initProp() {
		 prop=new Properties();
		 
		 try {
			FileInputStream io= new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(io);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch(IOException e) {
			 e.printStackTrace();		 
		 }
		 return prop;
	}
	
	


	

}
