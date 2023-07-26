package com.capgemini.stepdefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

import com.capgemini.actions.MyLearningPageActions;
import com.capgemini.actions.TrainingAnalysisPageActions;
import com.capgemini.locators.MyLearningPage;
import com.capgemini.utils.DataStore;
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
	
//MyLearningPageActions myLearningPageActions = new MyLearningPageActions();
//	TrainingAnalysisPageActions trainingAnalysisPageActions = new TrainingAnalysisPageActions();
	DataStore dataStore = new DataStore();
	MyLearningPage myLearningPage;

//	@Before
//	public void browserLaunch() throws IOException {
//		Helper helper = new Helper();
//		try {
//			ReadConfig.initializePropertyFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String browserName = ReadConfig.prop.getProperty("browserName");
//		driver = helper.startBrowser(browserName);
//
//
//	}

	@Given("user lands on MyLearning page {string}")
	public void userLandsOnMyLearningPage(String url) {
		

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("--remote-allow-origins=*");
		//options.addArguments("--headless", "--disable-gpu", "--run-all-compositor-stages-before-draw");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
	
	}


	@When("user clicks on view all icon")
	public void userClicksOnViewAllIcon() {
		myLearningPage=new MyLearningPage(driver);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		myLearningPage.myLearningPageCourseDetails();
		myLearningPage.clickOnViewAllIcon();
	}


	@And("click on Due Date column")
	public void clickOnDueDateColumn() {
		TrainingAnalysisPage trainingAnalysisPage = new TrainingAnalysisPage(driver);
		 trainingAnalysisPage.clickOnDueDateColumn();
	}


	@Then("store Course details in excel sheet")
	public void storeCourseDetailsInExcelSheet() {
		TrainingAnalysisPage trainingAnalysisPage = new TrainingAnalysisPage(driver);
		String courseTitle =  trainingAnalysisPage.fetchCourseTitle();
		String header =  trainingAnalysisPage.fetchNameHeader();
		dataStore.createExcelSheetAndStoreInExcelSheet(courseTitle,0,0,header,1,1);
	}
}
