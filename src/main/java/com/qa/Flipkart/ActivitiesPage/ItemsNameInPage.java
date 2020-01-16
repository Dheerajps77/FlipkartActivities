package com.qa.Flipkart.ActivitiesPage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Flipkart.Utils.SeleniumUtils;

public class ItemsNameInPage {

	WebDriver driver;

	public ItemsNameInPage(WebDriver driver) {
		this.driver = driver;
	}

	AutoSuggestValuesInPage objAutoSuggestValuesInPage = new AutoSuggestValuesInPage(driver);
	By SEARCH_BUTTON = By.xpath("//div[starts-with(@class,'col-12-12 ')]/child::button");

	public boolean clicOnSearchButton(WebDriver driver) {
		WebElement element;
		boolean flag = false;
		try {
			element = driver.findElement(SEARCH_BUTTON);
			if (SeleniumUtils.clickOnElement(element)) {
				flag = true;
				System.out.println("Clicked on search button after entered product value");
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
	
	public boolean checkProductsName(String productValue) throws Exception
	{
		ArrayList<String> arrayList;
		boolean flag=false;
		try {			
			arrayList=SeleniumUtils.listOfProductsName(driver);
			int sizeOf=arrayList.size();
			Thread.sleep(2000);
			for(int i=1;i<sizeOf;i++)
			{
				String value=arrayList.get(i);
				if(value.contains(productValue))
				{
					flag=true;
					System.out.println( value + " contains the product name " + productValue);
				}
				else
				{
					flag=false;
					System.out.println( value + " does not contains the product name " + productValue);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	// This will check if product value is coming in auto Suggest dropdown value
	public boolean verifyProductsName(String productValue, String differentProductName) throws Exception {
		boolean flag = false;
		try {
			if (objAutoSuggestValuesInPage.clickOnLoginWindow(driver)) {
				if (objAutoSuggestValuesInPage.searchProduct(driver)) {
					if (objAutoSuggestValuesInPage.checkProductValue(driver, differentProductName)) {
						if (clicOnSearchButton(driver)) {
							Thread.sleep(2000);
							if(checkProductsName(productValue))
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
