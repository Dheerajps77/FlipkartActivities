package com.qa.Flipkart.ActivitiesTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Flipkart.ActivitiesPage.AutoSuggestValuesInPage;
import com.qa.Flipkart.ActivitiesPage.ItemsNameInPage;
import com.qa.Flipkart.TestBase.TestBase;

public class AutoSuggestValueTest extends TestBase {

	AutoSuggestValuesInPage objAutoSuggestValuesInPage;	
	@Test(priority=0)
	public void verifyAutoSuggestValueTest() {
		boolean flagverifyAutoSuggestValueTest;
		try {
			System.out.println("verifyAutoSuggestValueTest has been started");
			objAutoSuggestValuesInPage = new AutoSuggestValuesInPage(driver);
			flagverifyAutoSuggestValueTest = objAutoSuggestValuesInPage.verifyAutoSuggestValue("One Plus");
			Assert.assertTrue(flagverifyAutoSuggestValueTest,
					"One Plus value is not found in the Auto Suggest Drop Down Value");
			System.out.println("Auto suggest corresponding to 'One Plus' test has been passed");
			System.out.println("verifyAutoSuggestValueTest has been ended");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
