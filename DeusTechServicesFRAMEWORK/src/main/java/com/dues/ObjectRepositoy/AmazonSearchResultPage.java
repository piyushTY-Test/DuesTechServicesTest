package com.dues.ObjectRepositoy;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchResultPage {

	@FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']")
	private WebElement SrchProdname;

	public WebElement getSrchProdname() {
		return SrchProdname;
	}
	
	@FindBy(xpath="//span[text()='Apple iPhone XR (64GB) - Yellow']/../../../../../../../div[2]/div[1]/div/div[1]/div/div/a/span[1]/span[2]/span[2]")
	private WebElement prodPrice;
	
	/**
	 * Description:Getting price of IphoneXR from Amazon And Coverting Into Integer
	 * @Author:Piyush singh
	 */
	public int getPrice() {
		String price= prodPrice.getText();
		 String[] s=price.split(",");
			String amaznP="";
			try {
				for(int i=0;i<=s.length;i++)
				{
					 amaznP=amaznP+s[i];
					 
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			return  Integer.parseInt(amaznP);
	}
	
	
	
}
