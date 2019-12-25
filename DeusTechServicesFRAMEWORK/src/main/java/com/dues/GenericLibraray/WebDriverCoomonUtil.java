package com.dues.GenericLibraray;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCoomonUtil {
	/*Implicit wait*/
	public void waitForPageToLoad()
	{
		BaseClass.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	/*Explicit wait*/
	public void waitForElementPresent(WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*Select Class to Handle Drop Down By Visible text*/
    public void select(WebElement element,String Data)
    {
    	Select sel=new Select(element);
    	sel.selectByVisibleText(Data);
    }
    
    /*Select Class to Handle Drop Down By Index Value*/
    public void select(WebElement element,int index)
    {
    	Select sel=new Select(element);
    	sel.selectByIndex(index);
    }
    
   /*Open New Tab*/
    public void newTab() throws AWTException
    {
    	 Robot r=new Robot();
    	 r.keyPress(KeyEvent.VK_CONTROL);
    	 r.keyPress(KeyEvent.VK_T);
    	 r.keyRelease(KeyEvent.VK_CONTROL);
    	 r.keyRelease(KeyEvent.VK_T);
    }
    
    /*Broser Scroll Bar*/
    public void broserVScroll(WebDriver driver,int verticalDist)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	
    	js.executeScript("Window.scrollTo(0,verticalDist)" );
    }
    
    public void broserScrollInto(WebDriver driver,WebElement element)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	
    	js.executeScript("arguments[0].scrollIntoView(true);",element );
    }
    
}
