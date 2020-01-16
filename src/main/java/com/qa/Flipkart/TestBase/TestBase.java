package com.qa.Flipkart.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

	public static WebDriver driver;

	@BeforeSuite
	public void openingBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com/");
		} catch (Exception e) {
			throw e;
		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}

}
