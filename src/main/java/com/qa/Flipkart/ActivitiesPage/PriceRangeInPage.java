package com.qa.Flipkart.ActivitiesPage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Flipkart.Utils.SeleniumUtils;

public class PriceRangeInPage {
	
	WebDriver driver;
	
	public PriceRangeInPage(WebDriver driver)
	{
		this.driver=driver;
	}

	AutoSuggestValuesInPage objAutoSuggestValuesInPage = new AutoSuggestValuesInPage(driver);
	ItemsNameInPage objItemsNameInPage=new ItemsNameInPage(driver);
		
	
	public boolean verifyProductsPrice() throws Exception
	{
		ArrayList<String> arrayList;
		boolean flag=false;
		try {			
			arrayList=SeleniumUtils.listOfProductsPrice(driver);
			int sizeOf=arrayList.size();
			Thread.sleep(2000);
			for(int i=1;i<sizeOf;i++)
			{
				String priceValue=arrayList.get(i);
				int currentPriceOfProduct=SeleniumUtils.conversionFromStringToInteger(priceValue);
				if((currentPriceOfProduct>=20000) && (currentPriceOfProduct<=40000))
				{
					flag=true;
					System.out.println( "The Price range of product " + currentPriceOfProduct + " is not less than 20,000 and it is greater than 20000 and less than 40,000");
				}
				else
				{
					flag=false;
					System.out.println( "The Price range of product " + currentPriceOfProduct + " is less than 20,000 and it is not greater than 20000 and less than 40,000");
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	// This will check if product value is coming in auto Suggest dropdown value
	public boolean verifyProductsPriceRange(String differentProductName) throws Exception {
		boolean flag = false;
		try {
			if (objAutoSuggestValuesInPage.clickOnLoginWindow(driver)) {
				if (objAutoSuggestValuesInPage.searchProduct(driver)) {
					if (objAutoSuggestValuesInPage.checkProductValue(driver, differentProductName)) {
						if (objItemsNameInPage.clicOnSearchButton(driver)) {
							Thread.sleep(2000);
							if(verifyProductsPrice())
							{
								flag=true;
							}
						}
					}
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

}
