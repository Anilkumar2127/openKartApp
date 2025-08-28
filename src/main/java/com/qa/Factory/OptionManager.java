package com.qa.Factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	
	Properties prop;
	public OptionManager(Properties prop) {
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions() {
		ChromeOptions co= new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			co.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
		}
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("browserName","chrome");
		}
		return co;
	}
	public FirefoxOptions getFireFoxOptions() {
		FirefoxOptions fo= new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			fo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			fo.addArguments("--incognito");
		}
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			fo.setCapability("browserName","firefox");
		}
		return fo;
	}
	public EdgeOptions getEdgeOptions() {
		EdgeOptions eo= new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))){
			eo.addArguments("--headless");
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			eo.addArguments("--InPrivate");
		}
		if(Boolean.parseBoolean(prop.getProperty("remote"))) {
			eo.setCapability("browserName","edge");
		}
		return eo;
	}

}
