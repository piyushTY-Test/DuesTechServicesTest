package com.dues.ObjectRepositoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlipkartSearchResultPage {
	
	@FindBy(xpath="//div[text()='Apple iPhone XR (Yellow, 64 GB)']")
	private WebElement flipSrchRes;
    @FindBy(xpath="//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../../div[2]/div[1]/div/div[1]")
    private WebElement flipProdPrice;
 
    
    public String getSearchRes() {
		return flipSrchRes.getText();
	}
	
    /**
     * Description:Getting price of IphoneXR from Flipkart And Coverting Into Integer
     * @Author:Piyush Singh
     */
    public int getFlipPrice() {
    	String FLipkP=flipProdPrice.getText();
    	String flipP="";
    	char[]ch=FLipkP.toCharArray();
    	for(int i=0;i<=ch.length-1;i++)
    	{
    		if(ch[i]>=48 && ch[i]<=57 )
    		{
    				flipP=flipP+ch[i];
    				
    			 
    		}
    	}
    	//Flipkart Price Of IphoneXR 
    	return Integer.parseInt(flipP);
	}
	
 
}
