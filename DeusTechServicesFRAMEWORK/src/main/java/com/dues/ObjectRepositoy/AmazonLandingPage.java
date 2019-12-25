package com.dues.ObjectRepositoy;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.dues.GenericLibraray.FileLibrary;

public class AmazonLandingPage {
	
	FileLibrary flib=new FileLibrary();
	
     @FindBy(id="twotabsearchtextbox")
     private WebElement amzSearchEdtBox;

	public WebElement getSearchEdtBox() {
		return amzSearchEdtBox;
	}
	
	/**
	 * Author:Piyush Singh
	 * Description:This is used to search product and reading product name from excel sheet
	 * @throws IOException
	 */
     public void searchProduct() throws IOException
     {
    	 String prodName=flib.getExcelData("Sheet1", 1, 2);
    	 amzSearchEdtBox.sendKeys(prodName,Keys.ENTER);
     }
}
