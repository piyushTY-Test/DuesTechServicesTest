package com.dues.GenericLibraray;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
@Listeners(com.dues.GenericLibraray.ListenerImpClass.class)
public class BaseClass {
	
 public  static WebDriver driver;
 @BeforeClass
  public void launchBrowser() throws IOException, Throwable
  {
	 FileLibrary flib=new FileLibrary();
	
	 String BROWSER=flib.getPropertyKeyValue("browser");
	 driver=null;
     if(BROWSER.equals("firefox"))
	 {
	    
		 driver=new FirefoxDriver();
		 Reporter.log("Launch The FireFox Browser", true);
		
	 }
     else if(BROWSER.equals("chrome"))
	 {
		 driver=new ChromeDriver();
		 Reporter.log("Launch The Chrome Browser", true);
	 }
	 else if(BROWSER.equals("ie"))
	 {
		 driver=new InternetExplorerDriver();
		 Reporter.log("Launch The IE Browser", true);
	 }
	 
	 /* Maximise Browser */
	 driver.manage().window().maximize();
		
  }
 
 @BeforeMethod	
 public void login() throws Throwable
 {      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    FileLibrary flib=new FileLibrary();
	    
	    String amazonURL=flib.getPropertyKeyValue("amazonUrl");
	    Reporter.log("Enter Amazon Url", true);
	    driver.get(amazonURL);
	   
	   
 }	
			
 
//@AfterMethod
//public void signOut() throws Throwable
//{   
//	
//}

@AfterClass
public void closeBrowser()
{
 Reporter.log("Close The Browser", true);
driver.close();
}
}
