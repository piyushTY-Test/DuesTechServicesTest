package com.dues.Test;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dues.GenericLibraray.BaseClass;
import com.dues.GenericLibraray.FileLibrary;
import com.dues.GenericLibraray.WebDriverCoomonUtil;
import com.dues.ObjectRepositoy.AmazonLandingPage;
import com.dues.ObjectRepositoy.AmazonSearchResultPage;
import com.dues.ObjectRepositoy.FlipkartLandingPage;
import com.dues.ObjectRepositoy.FlipkartSearchResultPage;
@Listeners(com.dues.GenericLibraray.ListenerImpClass.class)

/**
 * 
 * @author Piyush Singh
 *
 */
public class CompareIphoneXRPriceTest extends BaseClass {
@Test
public void _CompareIphoneXRPriceTest() throws IOException, AWTException {
	WebDriverCoomonUtil wdriver=new WebDriverCoomonUtil();
	wdriver.waitForPageToLoad();
	FileLibrary flib=new FileLibrary();
	
	 //Navigate To Amazonlanding Page
	AmazonLandingPage amalandpg=PageFactory.initElements(BaseClass.driver ,AmazonLandingPage.class);
	
	//iphonexr 64 gb yellow searched
	amalandpg.searchProduct();
	
	//Naviagte To Search Result Page
	AmazonSearchResultPage searchResPg=PageFactory.initElements(BaseClass.driver, AmazonSearchResultPage.class);
	
	//Validation oF Search Result
	String actProdName=searchResPg.getSrchProdname().getText();
	String expProdName="Apple iPhone XR (64GB) - Yellow";
	Reporter.log(actProdName, true);
	boolean valRes=actProdName.equals(expProdName);
	Assert.assertTrue(valRes);
	
	Reporter.log("Search Result Validated Successfully And Saerch Result Is ===>"+actProdName, true);
	
	//Get Price Of Product
	int amazonPrice=searchResPg.getPrice();
	
	
	//Open New Tab Using Robot Class
	wdriver.newTab();
	
	//Naviagte To Flipkart.Com
	 driver.manage().window().maximize();
	
	
	 
	//Get All Window Handles
		Set<String> set=driver.getWindowHandles();
		//Capture session Id From Set Collection
		Iterator<String> it=set.iterator();
		String amazonID=it.next();
		String flpkrtID=it.next();
		System.out.println(flpkrtID);
		
		
		//Get Current window Handle
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		
		//Pass Driver Control To FLipkart Page
		driver.switchTo().window(flpkrtID);
	
	   String flipkartURL=flib.getPropertyKeyValue("flipkartUrl");
	   driver.get(flipkartURL);
	
	
	
	FlipkartLandingPage flipPg=PageFactory.initElements(BaseClass.driver, FlipkartLandingPage.class);
	
	 //Click On Login Window pop up
	 flipPg.clkpopUpWin();

	 //Search Product IphoneXR
	 flipPg.searchprod();
	
	
	FlipkartSearchResultPage flipSearchPg=PageFactory.initElements(BaseClass.driver,FlipkartSearchResultPage.class);
	
	//Validate Search Result
	String actRes=flipSearchPg.getSearchRes();
	String expRes="Apple iPhone XR (Yellow, 64 GB)";
	boolean FlipRes=actRes.equals(expRes);
	Assert.assertTrue(FlipRes);
	Reporter.log("Flipkart Page Result Validated Succesfully====>"+actRes, true);
	
	// Price Of IphoneXR On FLipkart
	int flipkartPrice= flipSearchPg.getFlipPrice();
    Reporter.log("Price Of IphoneXR 64GB On Flipkart =====>"+flipkartPrice, true);
    
    //Closing FLipkart Window
	driver.close();
	
	//Switching To Amazon Window
	driver.switchTo().window(amazonID);
	
	//Comparing Price of IphoneXR of FLipkart And Amazon 
	if(amazonPrice>flipkartPrice)
	{
		Reporter.log(" Iphone XR Price In Flipkart Is Less Then Amazon And Iphone XR Price In Flipkart is ====> "+flipkartPrice, true);
	}
	else
	{
		Reporter.log(" Iphone XR Price In Amazon Is Less Then  Flipkart And Iphone XR Price In Amazon is ====> "+amazonPrice, true);
	}
	
	Reporter.log("CompareIphoneXRPriceTest Validated Succesfully", true);
	
	
}
}
