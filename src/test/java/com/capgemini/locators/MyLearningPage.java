package com.capgemini.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MyLearningPage {


    @FindBy(xpath = "//*[@data-title='My Mandatory Courses']")
    public WebElement mandatoryCourseTitle;

    @FindBy(xpath = "//*[@class='deepLinkIcon']")
    public List<WebElement> viewAll;
    WebDriver driver;

    public MyLearningPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void myLearningPageCourseDetails(){
        String text = mandatoryCourseTitle.getText();
        System.out.println("title is::"+text);
    }

    public void clickOnViewAllIcon(){
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.visibilityOf((WebElement) viewAll));
        viewAll.get(0).click();
    }


}
