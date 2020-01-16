package com.qa.Flipkart.ActivitiesTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Flipkart.ActivitiesPage.AutoSuggestValuesInPage;
import com.qa.Flipkart.ActivitiesPage.ItemsNameInPage;
import com.qa.Flipkart.TestBase.TestBase;

public class ItemsNameTest extends TestBase{
	
	ItemsNameInPage objItemsNameInPage;	
	@Test(priority=0)	
	public void verifyProductsNameTest() {
		boolean flagverifyverifyProductsNameTest;
		try {
			System.out.println("verifyProductsNameTest has been started");
			objItemsNameInPage = new ItemsNameInPage(driver);	
			flagverifyverifyProductsNameTest = objItemsNameInPage.verifyProductsName("OnePlus", "One Plus");
			Assert.assertTrue(flagverifyverifyProductsNameTest,
					"OnePlus Product name is not found product category");
			System.out.println("Result page has actual 'OnePlus' items test has been passed");
			System.out.println("verifyProductsNameTest has been ended");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
