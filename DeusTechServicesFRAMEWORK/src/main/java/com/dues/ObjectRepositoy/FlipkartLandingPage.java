package com.dues.ObjectRepositoy;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dues.GenericLibraray.FileLibrary;
import com.dues.GenericLibraray.WebDriverCoomonUtil;

public class FlipkartLandingPage {
  
	WebDriverCoomonUtil wb=new WebDriverCoomonUtil();
	FileLibrary flib=new FileLibrary();
	
	@FindBy(xpath="//button[text()='✕']")
	private WebElement logInPopUpWin;
	
	public WebElement getLogInPopUpWin() {
		return logInPopUpWin;
	}

	public void clkpopUpWin()
	{
		wb.waitForElementPresent(logInPopUpWin);
		logInPopUpWin.click();
	}
	
	@FindBy(name="q")
	private WebElement flipSearchEdtBox;
	
	/**
	 * Description:Reading Data from Excel Sheet And Entering Into SearchBox Of Flipkart 
	 * @throws IOException
	 */
	public void searchprod() throws IOException
	{
		String prodName=flib.getExcelData("Sheet1",1, 2);
		flipSearchEdtBox.sendKeys(prodName,Keys.ENTER);
	}
}
