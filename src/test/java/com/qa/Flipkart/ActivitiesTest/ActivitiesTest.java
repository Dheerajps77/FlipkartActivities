package com.qa.Flipkart.ActivitiesTest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.qa.Flipkart.ActivitiesPage.AutoSuggestValuesInPage;
import com.qa.Flipkart.ActivitiesPage.ItemsNameInPage;
import com.qa.Flipkart.ActivitiesPage.PriceRangeInPage;
import com.qa.Flipkart.TestBase.TestBase;

public class ActivitiesTest extends TestBase {

	ItemsNameInPage objItemsNameInPage;
	AutoSuggestValuesInPage objAutoSuggestValuesInPage;
	PriceRangeInPage ObjPriceRangeInPage;

	@Test(priority = 0)
	public void verifyProductsNameTest() {
		boolean flagverifyverifyProductsNameTest;
		try {
			startTest(properties.getLogMessage("VerifyProductNameInPage"),properties.getLogMessage("VerifyDetailsOfProductNameInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyProductNameInPage"));
			objItemsNameInPage = new ItemsNameInPage(driver);
			flagverifyverifyProductsNameTest = objItemsNameInPage.verifyProductsName("OnePlus", "One Plus");
			Assert.assertTrue(flagverifyverifyProductsNameTest,String.format(properties.getLogMessage("VerifyProductNameInPageTestFailed")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void verifyAutoSuggestValueTest() {
		boolean flagverifyAutoSuggestValueTest;
		try {
			startTest(properties.getLogMessage("VerifyAutoSuggestValueInPage"),properties.getLogMessage("VerifyDetailsPresentOnAutoSuggestValueInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyAutoSuggestValueInPage"));
			objAutoSuggestValuesInPage = new AutoSuggestValuesInPage(driver);
			flagverifyAutoSuggestValueTest = objAutoSuggestValuesInPage.verifyAutoSuggestValue("One Plus");
			Assert.assertTrue(flagverifyAutoSuggestValueTest,String.format(properties.getLogMessage("VerifyAutoSuggestValueInPageTestFailed")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority=2)
	public void verifyProductsPriceTest() throws Exception {
		boolean flagverifyverifyObjPriceRangeInPageTest;
		try {
			startTest(properties.getLogMessage("VerifyPriceRangeOfProductValueInPage"),properties.getLogMessage("VerifyDetailsOfPriceRangeOfProductValueInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyPriceRangeOfProducttValueInPage"));			
			ObjPriceRangeInPage = new PriceRangeInPage(driver);
			flagverifyverifyObjPriceRangeInPageTest = ObjPriceRangeInPage.verifyProductsPriceRange("One Plus");
			Assert.assertTrue(flagverifyverifyObjPriceRangeInPageTest,String.format(properties.getLogMessage("VerifyPriceRangeOfProductValueInPageTestFailed")));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test(priority = 3, description = "Verify Registration functionality")
	public void verifyRegisterationOnHomePage() {

		try {
			boolean flagRegistration= true;
			startTest(properties.getLogMessage("VerifyRegistrationInPage"),properties.getLogMessage("VerifyDetailsOfRegistrationInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyRegistrationInPage"));
			Assert.assertTrue(flagRegistration,String.format(properties.getLogMessage("VerifyRegistrationInPageTestFailed")));
			
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 4, description = "Verify Contact list functionality")
	public void verifyContactListOnPage() {

		try {
			boolean flagContactList= true;
			startTest(properties.getLogMessage("VerifyContactListInPage"),properties.getLogMessage("VerifyDetailsOfContactListInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyContactListInPage"));
			Assert.assertTrue(flagContactList,String.format(properties.getLogMessage("VerifyContactListInPageTestFailed")));
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 5, description = "Verify ForgetPassword functionality")
	public void verifyForgetPasswordOnPage() {

		try {
			boolean flagForgetPassword= true;
			startTest(properties.getLogMessage("VerifyForgetPasswordInPage"),properties.getLogMessage("VerifyDetailsOfForgetPasswordInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyForgetPasswordInPage"));
			Assert.assertTrue(flagForgetPassword,String.format(properties.getLogMessage("VerifyForgetPasswordInPageTestFailed")));
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 6, description = "Verify Remember Password functionality")
	public void verifyRememberPasswordOnPage() {

		try {
			boolean flagRememberPassword= true;
			startTest(properties.getLogMessage("VerifyRememberPasswordInPage"),properties.getLogMessage("VerifyDetailsOfRememberPasswordInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyRememberPasswordInPage"));
			Assert.assertTrue(flagRememberPassword,String.format(properties.getLogMessage("VerifyRememberPasswordInPageTestFailed")));
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 7, description = "Verify LogOut functionality")
	public void verifyLogOutOnPage() {

		try {
			boolean flagLogOut= true;
			startTest(properties.getLogMessage("VerifyLogOutInPage"),properties.getLogMessage("VerifyDetailsOfLogOutInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyLogOutInPage"));
			Assert.assertTrue(flagLogOut,String.format(properties.getLogMessage("VerifyLogOutInPageTestFailed")));
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 8, description = "Verify Digital Downloads Tab functionality")
	public void verifyDownloadsTabOnPage() {

		try {
			boolean flagDownloadsTab= true;
			startTest(properties.getLogMessage("VerifyDownloadTabInPage"),properties.getLogMessage("VerifyDetailsOfDownloadTabInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyDownloadTabInPage"));
			Assert.assertTrue(flagDownloadsTab,String.format(properties.getLogMessage("VerifyDownloadTabInPageTestFailed")));
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 9, description = "Verify Computers Tab functionality")
	public void verifyComputersTabOnPage() {

		try {
			boolean flagComputersTab= true;
			startTest(properties.getLogMessage("VerifyComputersTabInPage"),properties.getLogMessage("VerifyDetailsOfComputersTabInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyComputersTabInPage"));
			Assert.assertTrue(flagComputersTab,String.format(properties.getLogMessage("VerifyComputersTabInPageTestFailed")));
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 10, description = "Verify Electronic Tab functionality")
	public void verifyElectronicTabOnPage() {

		try {
			boolean flagElectronicTab= true;
			startTest(properties.getLogMessage("VerifyElectronicTabInPage"),properties.getLogMessage("VerifyDetailsOfElectronicTabInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyElectronicTabInPage"));
			Assert.assertTrue(flagElectronicTab,String.format(properties.getLogMessage("VerifyElectronicTabInPageTestFailed")));
		} catch (Exception e) {
			throw e;
		}
	}

	@Test(priority = 11, description = "Verify Gift Tab functionality")
	public void verifyGiftOnPage() {

		try {
			startTest(properties.getLogMessage("VerifyGiftInPage"),properties.getLogMessage("VerifyDetailsOfGiftInPage"));
			setTestCategory(properties.getLogMessage("CategoryVerifyGiftInPage"));
			throw new SkipException("Skipping this one test. Hence not testing");
		} catch (Exception e) {
			throw e;
		}
	}

}
