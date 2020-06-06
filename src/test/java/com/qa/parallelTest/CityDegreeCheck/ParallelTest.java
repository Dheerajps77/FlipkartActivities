package com.qa.parallelTest.CityDegreeCheck;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTest {

	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void initiateBrowser(String browser) {
		try {
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.out.println("Executing in " + browser);
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Resources/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("ff"))
			{
				System.out.println("Executing in " + browser);
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Resources/Drivers/geckodriver.exe");
				driver=new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("ie"))
			{
				System.out.println("Executing in " + browser);
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/Resources/Drivers/IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}
			else if(browser.equalsIgnoreCase("edge"))
			{
				System.out.println("Executing in " + browser);
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/Resources/Drivers/msedgedriver.exe");
				driver=new EdgeDriver();
			}				
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
		} catch (Exception e) {
			throw e;
		}
	}
	
	@DataProvider(name="dataOfCityName")
	public Object[][] cityNameWithWeatherText()
	{
		// [row][column]
		Object[][] data = new Object[6][2];
		try {
			data[0][0]="weather in  ";
			data[0][1]="Delhi";
			
			data[1][0]="weather in  ";
			data[1][1]="Banda Aceh";
			
			data[2][0]="weather in  ";
			data[2][1]="Badalona";
			
			data[3][0]="weather in  ";
			data[3][1]="Bakersfield";
			
			data[4][0]="weather in  ";
			data[4][1]="Baguio";
			
			data[5][0]="weather in  ";
			data[5][1]="Baltimore";
			
			/*data[6][0]="weather in  ";
			data[6][1]="Bangaon";*/
			
		} catch (Exception e) {
			throw e;
		}
		return data;
	}
	
	@Test(dataProvider="dataOfCityName")
	public void verifyCityName(String weatherName, String cityName) throws Exception
	{
		WebElement TEXT_BOX;
		WebElement DEGREE_IN_NUMBER;
		WebElement UNIT_OF_DEGREE;
		WebElement CITY_NAME_OF_AFTER_SEARCH;
		String cityNameAfterSearch;
		String numberOfDegree;
		String degreeOfUnit;
		try {			
			TEXT_BOX=driver.findElement(By.xpath("//input[@name='q']"));
			TEXT_BOX.sendKeys(weatherName + cityName);
			TEXT_BOX.submit();
			Thread.sleep(2000);			
			CITY_NAME_OF_AFTER_SEARCH=driver.findElement(By.xpath("//div[@id='wob_wc']/child::span/child::div[1]"));
			cityNameAfterSearch=CITY_NAME_OF_AFTER_SEARCH.getText();
			Assert.assertTrue(cityNameAfterSearch.contains(cityName), "City name doest not have city name");
			DEGREE_IN_NUMBER=driver.findElement(By.xpath("//div[@class='vk_bk sol-tmp']//span[1]"));
			numberOfDegree=DEGREE_IN_NUMBER.getText();
			UNIT_OF_DEGREE=driver.findElement(By.xpath("//div[@class='vk_bk wob-unit']/child::span[1]"));
			degreeOfUnit=UNIT_OF_DEGREE.getText();
			System.out.println(Thread.currentThread() + " " + Thread.activeCount());
			System.out.println(cityNameAfterSearch + " " + numberOfDegree + " " +degreeOfUnit);			
		} catch (Exception e) {
			throw e;
		}
	}
	

	@AfterMethod
	public void closeBrowser() {
		try {
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
