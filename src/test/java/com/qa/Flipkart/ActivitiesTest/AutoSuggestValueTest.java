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
			startTest(properties.getLogMessage("VerifyAutoSuggestValueInPage"),properties.getLogMessage("VerifyDetailsPresentOnAutoSuggestValueInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAutoSuggestValueInPage"));			
			objAutoSuggestValuesInPage = new AutoSuggestValuesInPage(driver);
			flagverifyAutoSuggestValueTest = objAutoSuggestValuesInPage.verifyAutoSuggestValue("One Plus");
			Assert.assertTrue(flagverifyAutoSuggestValueTest,String.format(properties.getLogMessage("VerifyAutoSuggestValueInPageTestFailed")));
			System.out.println("Auto suggest corresponding to 'One Plus' test has been passed");
			System.out.println("verifyAutoSuggestValueTest has been ended");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
}
