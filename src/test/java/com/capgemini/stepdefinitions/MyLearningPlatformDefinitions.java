package com.capgemini.stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import com.capgemini.actions.MyLearningPageActions;
import com.capgemini.actions.TrainingAnalysisPageActions;
import com.capgemini.locators.MyLearningPage;
import com.capgemini.utils.DataStore;
import com.capgemini.utils.SendMail;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.capgemini.utils.Helper;
import com.capgemini.utils.ReadConfig;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.capgemini.locators.TrainingAnalysisPage;

public class MyLearningPlatformDefinitions {
	WebDriver driver = null;
	
	DataStore dataStore = new DataStore();

	MyLearningPage myLearningPage;


	@Given("user lands on MyLearning page {string}")
	public void userLandsOnMyLearningPage(String url) {
		Helper helper = new Helper();
		try {
			ReadConfig.initializePropertyFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browserName = ReadConfig.prop.getProperty("browserName");
		driver = helper.startBrowser(browserName);
		driver.get(url);
	}


	@When("user clicks on view all icon")
	public void userClicksOnViewAllIcon() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		myLearningPage=new MyLearningPage(driver);
		myLearningPage.myLearningPageCourseDetails();
		myLearningPage.clickOnViewAllIcon();
	}


	@And("select Recommended from filter")
	public void selectRecommendedFromFilter() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		TrainingAnalysisPage trainingAnalysisPage = new TrainingAnalysisPage(driver);
		trainingAnalysisPage.selectFilter();
	}


	@Then("store Course details in excel sheet")
	public void storeCourseDetailsInExcelSheet() {
        System.out.println("started storing data");
		dataStore.createExcelSheetAndStoreInExcelSheet();
		SendMail sendMail = new SendMail();
		sendMail.sendMail();	
	}
}
