package com.qa.Flipkart.ActivitiesTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataDrivenWithoutApachePOI {
	
	WebDriver driver;
	
	/*@BeforeMethod*/
	public void openingBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.get("https://ui.cogmento.com/");
		} catch (Exception e) {
			throw e;
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	@Test(dataProvider="dataProvider")
	public void loginWithDetails(String userName, String password) throws Exception
	{
		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);		
			driver.get("https://ui.cogmento.com/");		
			Thread.sleep(2000);
			driver.findElement(By.name("email")).sendKeys(userName);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//div[text()='Login']")).click();
			Thread.sleep(3000);
			boolean flag=checkIfElementPresent(driver.findElement(By.xpath("//div[@class='ui fluid card']/child::div/div[text()='Contacts activity stream']")));
			if(!flag)
			{
				Assert.assertTrue(flag, "Test case failed because customer not able to logged In");
			}			
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	public boolean checkIfElementPresent(WebElement element)
	{
		boolean flag=false;
		try {
			if(element.isDisplayed())
			{
				flag=true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
	
	@DataProvider(name="dataProvider")
	public Object[][] getData()
	{
		Object[][] testData=new Object[3][2];
		try {
			testData[0][0]="nitin1tester@gmail.com";
			testData[0][1]="Nitin98581444";
			
			testData[1][0]="nitin1tester@gmail.com";
			testData[1][1]="Nitin98581";
			
			testData[2][0]="pavantraining@gmail.com";
			testData[2][1]="Test@123q";
			
		} catch (Exception e) {
			throw e;
		}
		return testData;
	}

}
