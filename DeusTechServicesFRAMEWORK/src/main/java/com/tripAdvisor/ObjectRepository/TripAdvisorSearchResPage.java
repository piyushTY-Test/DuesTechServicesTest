package com.tripAdvisor.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dues.GenericLibraray.WebDriverCoomonUtil;

public class TripAdvisorSearchResPage {
    
	WebDriverCoomonUtil wdriver=new WebDriverCoomonUtil();
	WebDriver driver;
	
	@FindBy(xpath="//a[@class='ui_button primary']")
	private WebElement writeReviewBtn;
	
	public void clickReviewBtn() 
	{try {
//		wdriver.broserScrollInto(driver, writeReviewBtn);
		writeReviewBtn.click();
	} catch (Exception e) {
		// TODO: handle exception
	}
		
	}
	
}
