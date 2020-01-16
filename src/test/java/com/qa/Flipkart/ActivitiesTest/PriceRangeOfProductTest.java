package com.qa.Flipkart.ActivitiesTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Flipkart.ActivitiesPage.PriceRangeInPage;
import com.qa.Flipkart.TestBase.TestBase;

public class PriceRangeOfProductTest extends TestBase {
	
	
	PriceRangeInPage ObjPriceRangeInPage;	
	@Test(priority=0)	
	public void verifyProductsPriceTest() throws Exception {
		boolean flagverifyverifyObjPriceRangeInPageTest;
		try {
			System.out.println("verifyProductsPriceTest has been started");
			ObjPriceRangeInPage = new PriceRangeInPage(driver);	
			flagverifyverifyObjPriceRangeInPageTest = ObjPriceRangeInPage.verifyProductsPriceRange("One Plus");
			Assert.assertTrue(flagverifyverifyObjPriceRangeInPageTest,"Price range 20,000 to 40,000' of items test failed");
			System.out.println("Price range 20,000 to 40,000' of items test has been passed");
			System.out.println("verifyProductsPriceTest has been ended");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

}
