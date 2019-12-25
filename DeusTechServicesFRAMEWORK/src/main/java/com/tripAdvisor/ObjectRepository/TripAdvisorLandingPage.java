package com.tripAdvisor.ObjectRepository;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.dues.GenericLibraray.FileLibrary;
import com.dues.GenericLibraray.WebDriverCoomonUtil;

public class TripAdvisorLandingPage {
	WebDriver driver;
	WebDriverCoomonUtil wdriver=new WebDriverCoomonUtil();
	FileLibrary flib=new FileLibrary();
	@FindBy(xpath="//span[text()='Search']")
	private WebElement search;
	
	@FindBy(id="mainSearch")
	private WebElement mainSearch;
	
	@FindBy(id="59cb4f8e-ab0d-4019-a459-7d22a3d67c2f")
	private WebElement frameSearch;
	
	@FindBy(id="BODY_BLOCK_JQUERY_REFLOW")
	private WebElement mainSearch2;
	
	@FindBy(xpath="//div[@class='result-title']")
	private List<WebElement> lstSearchRes;
	
	public void searchBox() throws IOException
	{
		try {
			//wdriver.waitForElementPresent(search);
			String SrchData=flib.getExcelData("Sheet1",4,2);
			search.click();
			//wdriver.waitForElementPresent(mainSearch);
			mainSearch.sendKeys(SrchData,Keys.ENTER);
			
		} catch (Exception e) {
			String SrchData=flib.getExcelData("Sheet1",4,2);
			mainSearch2.click();
			driver.switchTo().frame(frameSearch);
			mainSearch2.sendKeys(SrchData,Keys.ENTER);
		}
		
	}
	
	public void clickFirstRes() {
		lstSearchRes.get(0).click();
	}

}
