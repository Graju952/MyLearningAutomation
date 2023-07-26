package com.capgemini.utils;

import org.openqa.selenium.WebDriver;

public class BaseClass {
	
	private static WebDriver driver;
	
	public BaseClass(WebDriver driver2) {
		BaseClass.driver = driver;
	}
	

}
