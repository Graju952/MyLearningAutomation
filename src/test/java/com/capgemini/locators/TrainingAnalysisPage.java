package com.capgemini.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TrainingAnalysisPage {

	 WebDriver driver;
	 public TrainingAnalysisPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

    @FindBy(id ="RequiredIndView")
    public List<WebElement> filterDropDown;

    @FindBy(xpath = "//*[@class='clsALink']")
    public List<WebElement> courseTitle;

    @FindBy(xpath = "//*[@class='clsTableHeadingCellLink']")
    public List<WebElement> columnHeaders;


    // To be change below locator once dev add the locators for course details
    @FindBy(xpath = "//*[@class='clsTableCell']") // starts from 2 and +15 difference for every row
    public List<WebElement> courseDetails;

    @FindBy(xpath = "//*[@role='columnheader']") // starts from index 3
    public List<WebElement> headers;

    public void clickOnDueDateColumn(){
        columnHeaders.get(4).click();
    }

    public String fetchCourseTitle(){
        String title = courseTitle.get(0).getText();
        return title;
    }
    public String fetchCourseDueDate(){
        String courseDueDate = courseDetails.get(10).getText();
        return courseDueDate;
    }

    public String fetchNameHeader(){
        String nameHeader = headers.get(3).getText();
        return nameHeader;
    }

}
