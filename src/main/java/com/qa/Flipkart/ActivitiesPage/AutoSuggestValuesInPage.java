package com.qa.Flipkart.ActivitiesPage;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Flipkart.Utils.SeleniumUtils;

public class AutoSuggestValuesInPage {
	
	WebDriver driver;
	public AutoSuggestValuesInPage(WebDriver driver)
	{
		this.driver=driver;
	}
	By CLOSE_LOGINWINDOW = By.xpath("//div[@class='_3Njdz7']/child::button");
	By SEARCH_PRODUCTS_TEXTBOX = By.xpath("//input[@name='q']");	
	
	// This will close the login window pop-up
	public boolean clickOnLoginWindow(WebDriver driver) {
		boolean flag = false;
		WebElement loginWindow;
		try {
			loginWindow = driver.findElement(CLOSE_LOGINWINDOW);
			if (SeleniumUtils.clickOnElement(loginWindow)) {
				flag = true;
				System.out.println("Click on Close button of Login Pop-Up window");
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	// This will search specific product items
	public boolean searchProduct(WebDriver driver) {
		WebElement enterProductName;
		boolean flag = false;
		try {
			enterProductName = driver.findElement(SEARCH_PRODUCTS_TEXTBOX);
			if (SeleniumUtils.sendText(enterProductName, "One Plus")) {
				flag = true;
				System.out.println("Product value has been entered");
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	public boolean checkProductValue(WebDriver driver, String productValue) throws Exception
	{
		ArrayList<String> arrayList;
		boolean flag=false;
		try {
			arrayList=SeleniumUtils.listOfProductsValue(driver);
			int sizeOf=arrayList.size();
			for(int i=1;i<sizeOf;i++)
			{
				String value=arrayList.get(i);
				if(value.contains(productValue.toLowerCase()))
				{
					flag=true;					
					System.out.println(value + " contain the value of " + productValue.toLowerCase());
				}
				else
				{
					System.out.println(value + " contain the value of " + productValue.toLowerCase());
					flag=false;
				}
			}			
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
	
	// This will check if product value is coming in auto Suggest dropdown value
	public boolean verifyAutoSuggestValue(String productValue) throws Exception {
		boolean flag=false;
		try {
			if (clickOnLoginWindow(driver)) {
				if (searchProduct(driver)) {
					if(checkProductValue(driver, productValue))
					{
						flag=true;						
					}
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

}
