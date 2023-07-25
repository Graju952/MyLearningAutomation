package com.capgemini.stepdefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.capgemini.utils.Helper;
import com.capgemini.utils.ReadConfig;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class MyLearningPlatformDefinitions {
	WebDriver driver;
	
	@Before
	public void browserLaunch() throws IOException
	{
		Helper helper = new Helper();   
		try {
			ReadConfig.initializePropertyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browserName=ReadConfig.prop.getProperty("browserName");
	    driver=helper.startBrowser(browserName);
		
	   
	}
		
	@Given("I Want to Login")
	public void I_Want_to_Login() {
		
		driver.get("https://mylearning.capgemini.com/");
	}


}
