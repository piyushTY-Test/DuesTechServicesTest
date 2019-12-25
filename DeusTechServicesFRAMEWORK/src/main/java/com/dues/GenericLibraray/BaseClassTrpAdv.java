package com.dues.GenericLibraray;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(com.dues.GenericLibraray.ListenerImpClass.class)
public class BaseClassTrpAdv {
	 public  static WebDriver driver;
	 @BeforeClass
	  public void launchBrowser() throws IOException, Throwable
	  {
		 FileLibrary flib=new FileLibrary();
		
		 String BROWSER=flib.getPropertyKeyValue("browser");
		 driver=null;
	     if(BROWSER.equals("firefox"))
		 {
	    	 Reporter.log("Launch The FireFox Browser", true);
			 driver=new FirefoxDriver();
	         
			
		 }
	     else if(BROWSER.equals("chrome"))
		 {
	    	 Reporter.log("Launch The Chrome Browser", true);
			 driver=new ChromeDriver();
			 
		 }
		 else if(BROWSER.equals("ie"))
		 {
			 Reporter.log("Launch The IE Browser", true);
			 driver=new InternetExplorerDriver();
			 
		 }
		 
		 /* Maximise Browser */
		 driver.manage().window().maximize();
			
	  }
	 
	 @BeforeMethod	
	 public void login() throws Throwable
	 {      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		    FileLibrary flib=new FileLibrary();
		    
		    String tripAdvisorURL=flib.getPropertyKeyValue("tripadvisorUrl");
		    
		    driver.get(tripAdvisorURL);
		    Reporter.log(" TripAdvisor Landing Page", true);
		    
		   
		   
	 }	
				
	 
	//@AfterMethod
	//public void signOut() throws Throwable
	//{   
	//	
	//}

	@AfterClass
	public void closeBrowser()
	{
		Reporter.log("Close The  Browser", true);
	//driver.close();
	}
}
