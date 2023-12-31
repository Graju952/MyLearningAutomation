package com.capgemini.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Helper {
	
	ReadConfig rc = new ReadConfig();
	public static WebDriver driver;
	
	
	public  WebDriver startBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--remote-allow-origins=*");
			//options.addArguments("--headless", "--disable-gpu", "--run-all-compositor-stages-before-draw");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			EdgeOptions options = new EdgeOptions();
			 ChromeOptions opt = null;
			opt.addArguments("--remote-allow-origins=*");
		    driver = new EdgeDriver(options);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return driver;
	}
	
	public static void openPage(String url) {
		driver.get(url);
	}

//	public static WebDriver getDriver() {
//		return driver;
//	}
}



