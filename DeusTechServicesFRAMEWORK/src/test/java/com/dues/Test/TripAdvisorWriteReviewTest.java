package com.dues.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dues.GenericLibraray.BaseClassTrpAdv;
import com.dues.GenericLibraray.WebDriverCoomonUtil;
import com.tripAdvisor.ObjectRepository.TripAdvisorLandingPage;
import com.tripAdvisor.ObjectRepository.TripAdvisorSearchResPage;
import com.tripAdvisor.ObjectRepository.TripAdvisorWriteAReviewPage;
//@Listeners(com.dues.GenericLibraray.ListenerImpClass.class)
public class TripAdvisorWriteReviewTest extends BaseClassTrpAdv {
	@Test
	public void _TripAdvisorWriteReviewTest() throws IOException, InterruptedException
	{
		WebDriverCoomonUtil wdriver=new WebDriverCoomonUtil();
		//Navigate To TripAdvisor Landing Page
		
		TripAdvisorLandingPage trpLandPg=PageFactory.initElements(BaseClassTrpAdv.driver, TripAdvisorLandingPage.class);
		
		//click On Search
		trpLandPg.searchBox();
		
		//Enter Search Data 
		trpLandPg.clickFirstRes();
		
		//Get All Window Handles
				Set<String> set=driver.getWindowHandles();
				//Capture session Id From Set Collection
				Iterator<String> it=set.iterator();
				String parentID=it.next();
				String childID1=it.next();
				
				//Get Current window Handle
				String parent=driver.getWindowHandle();
				System.out.println(parent);
				
				//Pass Driver Control To FLipkart Page
				boolean b=(parent!=childID1);
				Assert.assertTrue(b);
				driver.switchTo().window(childID1);
				
				 System.out.println(childID1);
				
              TripAdvisorSearchResPage TrpSrchPg=PageFactory.initElements(BaseClassTrpAdv.driver, TripAdvisorSearchResPage.class);
				
              TrpSrchPg.clickReviewBtn();
            
              String currntHandle=driver.getWindowHandle();
			   Set<String> set1=driver.getWindowHandles();
			   List<String> lst=new ArrayList<String>(set1);
			   int count=lst.size();
			   System.out.println(count);
			   String newChild=lst.get(2);
			   System.out.println(lst.get(0));
			   System.out.println(lst.get(1));
			   System.out.println(currntHandle);
			   System.out.println(newChild);
				
				
				driver.switchTo().window(newChild);
				
				TripAdvisorWriteAReviewPage reviewPg=PageFactory.initElements(BaseClassTrpAdv.driver,TripAdvisorWriteAReviewPage.class);
     			reviewPg.enterReviewTitle();
				reviewPg.enterReviewText();
				reviewPg.clickSubmitReview();
	}

}
