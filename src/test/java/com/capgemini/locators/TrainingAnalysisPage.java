package com.capgemini.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TrainingAnalysisPage {

	 WebDriver driver;
	 public TrainingAnalysisPage(WebDriver driver){
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

    @FindBy(xpath ="//*[@id='RequiredIndView']") 
    public WebElement filterDropDown;

    @FindBy(xpath = "//*[@class='clsALink']")
    public List<WebElement> courseTitle;

    @FindBy(xpath = "//*[@class='clsTableHeadingCellLink']")
    public List<WebElement> columnHeaders;
    
    @FindBy(xpath="//a[@role='button' and @class='clsTableHeadingCellLink' and @title='Sortable ' and text()='Due Date']")
    public WebElement dueDate;

   

    // To be change below locator once dev add the locators for course details
    @FindBy(xpath = "//*[@class='clsTableCell']") // starts from 2 and +15 difference for every row
    public List<WebElement> courseDetails;

    @FindBy(xpath = "//*[@role='columnheader']") // starts from index 3
    public List<WebElement> headers;

    public void selectFilter(){
    		driver.switchTo().frame("productPillarFrame");
            // TODO your stuff.
            	Select select = new Select(filterDropDown);
            	select.selectByIndex(1);
            }
//        
//    	driver.switchTo().frame(1);
//    	Select select = new Select(filterDropDown);
//    	select.selectByIndex(1);
//    	dueDate.click();
//        columnHeaders.get(4).click();
    

    public String fetchCourseTitle(){
    	driver.switchTo().frame("CoreIFrame");
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
