package com.qa.Flipkart.Utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {
	
	static By PRODUCT_LISTS=By.xpath("//ul[starts-with(@class,'col-12-12')]//li//div//a//div[2]");
	static By ROW_OF_ELEMENTS=By.xpath("//div[@id='container']//div[@class='_1HmYoV hCUpcT']/div[2]/div");
	static By COL_OF_ELEMENTS=By.xpath("//div[@id='container']/div/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div");
	// This will click on element, if element is present
	public static boolean clickOnElement(WebElement element) {
		boolean flag = false;
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				element.click();
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	// This will check if textBox is present and enter value in the textbox
	public static boolean sendText(WebElement element, String value) {
		boolean flag = false;
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.sendKeys(value);
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}
	
	public static ArrayList<String> listOfProductsValue(WebDriver driver) throws Exception
	{
		ArrayList<String> arraylist;
		List<WebElement> listOfElement;
		int totalCountOfSearchProduct;			
		try {
			arraylist=new ArrayList<String>();
			listOfElement=driver.findElements(PRODUCT_LISTS);
			totalCountOfSearchProduct=listOfElement.size();
			for(int i=1;i<=totalCountOfSearchProduct;i++)
			{
				Thread.sleep(1000);
				String productValue=driver.findElement(By.xpath("//ul[starts-with(@class,'col-12-12')]//li["+i+"]//div//a//div[2]")).getText();
				 //String productValue=element.getText();
				arraylist.add(productValue);
				
			}
		} catch (Exception e) {
			throw e;
		}
		return arraylist;
	}
	
	// This function will hold all the product name in the current home page of Flipkart
	public static ArrayList<String> listOfProductsName(WebDriver driver) throws Exception
	{
		ArrayList<String> arraylist;
		List<WebElement> listOfElement;
		List<WebElement> rowsOfElements;
		int countOfRows;
		String productValue;
		WebElement element;
		try {
			arraylist=new ArrayList<String>();
			listOfElement=driver.findElements(ROW_OF_ELEMENTS);
			int countOfCols=driver.findElements(COL_OF_ELEMENTS).size();
			countOfRows=listOfElement.size();
			for(int i=2;i<countOfRows-1;i++)
			{
				for(int j=1;j<=countOfCols;j++)
				{
				//Thread.sleep(1000);
				element=driver.findElement(By.xpath("//div[@id='container']//div[@class='_1HmYoV hCUpcT']/div[2]/div["+i+"]/div[@class='_3O0U0u']/div["+j+"]/div/a[2]"));
				productValue=element.getText();
				arraylist.add(productValue);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return arraylist;
	}
	
	// This function will hold all the product prices in the current home page of Flipkart
		public static ArrayList<String> listOfProductsPrice(WebDriver driver) throws Exception
		{
			ArrayList<String> arraylist;
			List<WebElement> listOfElement;
			List<WebElement> rowsOfElements;
			int countOfRows;
			String productValue;
			WebElement element;
			try {
				arraylist=new ArrayList<String>();
				listOfElement=driver.findElements(ROW_OF_ELEMENTS);
				int countOfCols=driver.findElements(COL_OF_ELEMENTS).size();
				countOfRows=listOfElement.size();
				for(int i=2;i<countOfRows-1;i++)
				{
					for(int j=1;j<=countOfCols;j++)
					{
					//Thread.sleep(1000);
					element=driver.findElement(By.xpath("//div[@id='container']//div[@class='_1HmYoV hCUpcT']/div[2]/div["+i+"]/div[@class='_3O0U0u']/div["+j+"]/div/a[3]/div[1]/div[1]"));
					productValue=element.getText();
					arraylist.add(productValue);
					}
				}
			} catch (Exception e) {
				throw e;
			}
			return arraylist;
		}
	
		// This functions will return the prices of product after the conversion in Integer format
	public static Integer conversionFromStringToInteger(String numberValues)
	{
		int priceValue;
		try {
			String str=numberValues.replaceAll("[₹,]", "");
			priceValue=Integer.parseInt(str);
		} catch (Exception e) {
			throw e;
		}
		return priceValue;
	}
	
	
	
	
}
