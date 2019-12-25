package com.tripAdvisor.ObjectRepository;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.dues.GenericLibraray.FileLibrary;
import com.dues.GenericLibraray.WebDriverCoomonUtil;

public class TripAdvisorWriteAReviewPage {
	WebDriver driver;
	WebDriverCoomonUtil wdriver=new WebDriverCoomonUtil();
	Actions act=new Actions(driver);
	FileLibrary flib=new FileLibrary();
@FindBy(id="bubble_rating")
private List<WebElement> HoverRating;

@FindBy(xpath="//div[text()='Hotel Ratings']")
private WebElement hotelRat;

@FindBy(xpath="//input[@id='ReviewTitle']")
private WebElement reviewTitle;

@FindBy(xpath="//textarea[@id='ReviewText']")
private WebElement reviewText;

@FindBy(id="noFraud")
private WebElement submitChkBox;
//noFraud SUBMIT
@FindBy(id="SUBMIT")
private WebElement submitBtn;


public String hoverToEle()
{String color=null;
	for(int i=0;i<=HoverRating.size()-1;i++)
	{
		act.moveToElement(HoverRating.get(i));
		color=HoverRating.get(HoverRating.size()-1).getCssValue("background-color");
		
	}return color;
}
public void scrollToHotelRat()
{
	wdriver.broserScrollInto(driver, hotelRat);
	boolean hotelRating=hotelRat.isDisplayed();
	Assert.assertTrue(hotelRating);
	Reporter.log("Hotel Rating is Displayed", true);
	
}

public void enterReviewTitle() throws IOException
{
	String title=flib.getExcelData("Sheet1",4,3);
	reviewTitle.sendKeys(title);
}
//ReviewText
public void enterReviewText() throws IOException
{
	String text=flib.getExcelData("Sheet1",4,4);
	reviewTitle.sendKeys(text);
}
public void clickSubmitReview()
{ 
	Assert.assertFalse(submitChkBox.isSelected()); 
	submitChkBox.click();
	Reporter.log("Submit Review CheckBox Selected", true);
	submitBtn.click();
	

}
}
