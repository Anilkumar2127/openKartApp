package com.qa.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.Exceptions.BrowserException;
import com.qa.Exceptions.FrameworkException;
/*
 * Properties Files initialization
 * Driver initialization
 */
public class DriverFactory {
	protected WebDriver driver = null;

	private static final Logger log = LogManager.getLogger(DriverFactory.class);
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	Properties prop=null;
	public static String highlight;
	OptionManager optmanager;

	public DriverFactory(WebDriver driver) {
		this.driver = driver;
	}

	
	/*
	 * Initialize the browser based on given browser name
	 * 
	 * @paramName=browserName
	 */
	public WebDriver initDriver(Properties prop) {
		log.info("Properties :"+ prop);
		String browserName=prop.getProperty("browser");
		highlight=prop.getProperty("highlight");
		log.info("browserName  :"+browserName);
		//System.out.println("====Browser Opening:==" + browserName);
		optmanager=new OptionManager(prop);
		
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			//driver = new ChromeDriver(optmanager.getChromeOptions());
			tldriver.set(new ChromeDriver(optmanager.getChromeOptions()));
			break;
		case "edge":
			//driver = new EdgeDriver(optmanager.getEdgeOptions());
			tldriver.set(new EdgeDriver(optmanager.getEdgeOptions()));
			break;
		case "firefox":
			//driver = new FirefoxDriver(optmanager.getFireFoxOptions());
			tldriver.set(new FirefoxDriver(optmanager.getFireFoxOptions()));
			break;
		default:
			System.out.println("Pass the valid browser");
			throw new BrowserException("===Invalid Browser===");
		}
		return tldriver.get();
	}
	
	public Properties initProp() {
		FileInputStream io= null;
		String envname=System.getProperty("env");
		try {
			if(envname==null) {
				log.info("Running the scripts in QA environment...");
				//System.out.println("Running the scripts in QA environment...");
				io= new FileInputStream("./src/test/resources/config/qa.config.properties");
			}
			else
			{
				switch(envname.toLowerCase().trim()) { 	
				case "qa":
					log.info("Running the scripts in environment..."+envname);
					//System.out.println("Running the scripts in environment..."+envname);
					io= new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "dev":
					log.info("Running the scripts in environment..."+envname);
					//System.out.println("Running the scripts in environment..."+envname);
					io= new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "uat":
					log.info("Running the scripts in environment..."+envname);
					//System.out.println("Running the scripts in environment..."+envname);
					io= new FileInputStream("./src/test/resources/config/uat.config.properties");
					break;
				
					default :
						log.warn("Invalid Environment :"+envname);
						throw new FrameworkException("Sry Invalid env..."+envname); 
				}
			}
			
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
		prop=new Properties();
		 try {
			prop.load(io);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 catch(IOException e) {
			 e.printStackTrace();		 
		 }
		 return prop;
	}
	
	
	/*Screenshot logic for ChainTestReport*/
	public static File takeScreenShot() {
		File fs=((TakesScreenshot)tldriver.get()).getScreenshotAs(OutputType.FILE);
		return fs;
	}
	
	/*Provide local webdriver using LocalThread Class*/
	
	public static WebDriver getDriver() {
		return tldriver.get();
	}


	

}
