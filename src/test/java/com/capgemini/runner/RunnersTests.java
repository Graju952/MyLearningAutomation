package com.capgemini.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
	       features={"src/test/java/com/capgemini/features/MyLearningPlatform.feature"},
	        glue= {"com/capgemini/stepdefinitions"},
	       /// plugin={"html:Reports/CucumberReport.html","junit:Reports/CucumberReport.xml","json:Reports/CucumberReport.json", "pretty", "html:target/cucumber-reports", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
	        		plugin= {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
	)

public class RunnersTests extends AbstractTestNGCucumberTests {

}
