package com.qa.parallelTest.CityDegreeCheck;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ApachePOIWithDataProvider {

	String excelSheetPath = System.getProperty("user.dir") + "/Test Data/TestData.xlsx";
	WebDriver driver;

	@BeforeMethod
	public void initiateBrowser(String browser) {
		try {
			System.out.println("Executing in " + browser);
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://www.google.com/");
		} catch (Exception e) {
			throw e;
		}
	}

	public Workbook getWorkBook() throws Exception {
		File file;
		FileInputStream fis;
		Workbook workBook;
		try {
			file = new File(excelSheetPath);
			fis = new FileInputStream(file);
			if (excelSheetPath.endsWith("xlsx")) {
				workBook = new XSSFWorkbook(fis);
			} else {
				workBook = new HSSFWorkbook(fis);
			}
		} catch (Exception e) {
			throw e;
		}
		return workBook;
	}

	@DataProvider(name = "dataUsingApachePOI")
	public Object[][] dataProviderReadingValueFromApachePOI() throws Exception {
		Workbook wb;
		Sheet sheet;
		Row row;
		Object[][] data;
		try {

			wb = getWorkBook();
			sheet = wb.getSheet("Sheet2");
			int rowData = sheet.getLastRowNum();
			int columnData = sheet.getRow(0).getLastCellNum();
			data = new Object[rowData][columnData];
			for (int i = 1; i <= rowData; i++) {
				row = sheet.getRow(i);
				for (int j = 0; j < columnData; j++) {
					Cell cell = row.getCell(j);
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						data[i - 1][j] = cell.getStringCellValue();
					} else {
						data[i = 1][j] = String.valueOf(cell.getNumericCellValue());
					}
				}
			}

		} catch (Exception e) {
			throw e;
		}
		return data;
	}

	@Test(dataProvider = "dataUsingApachePOI")
	public void testValueFromApachePOI(String weatherName, String cityName) throws Exception {
		try {
			WebElement TEXT_BOX;
			WebElement DEGREE_IN_NUMBER;
			WebElement UNIT_OF_DEGREE;
			WebElement CITY_NAME_OF_AFTER_SEARCH;
			String cityNameAfterSearch;
			String numberOfDegree;
			String degreeOfUnit;
			TEXT_BOX = driver.findElement(By.xpath("//input[@name='q']"));
			TEXT_BOX.sendKeys(weatherName + cityName);
			TEXT_BOX.submit();
			Thread.sleep(2000);
			CITY_NAME_OF_AFTER_SEARCH = driver.findElement(By.xpath("//div[@id='wob_wc']/child::span/child::div[1]"));
			cityNameAfterSearch = CITY_NAME_OF_AFTER_SEARCH.getText();
			Assert.assertTrue(cityNameAfterSearch.contains(cityName), "City name doest not have city name");
			DEGREE_IN_NUMBER = driver.findElement(By.xpath("//div[@class='vk_bk sol-tmp']//span[1]"));
			numberOfDegree = DEGREE_IN_NUMBER.getText();
			UNIT_OF_DEGREE = driver.findElement(By.xpath("//div[@class='vk_bk wob-unit']/child::span[1]"));
			degreeOfUnit = UNIT_OF_DEGREE.getText();
			System.out.println(Thread.currentThread() + " " + Thread.activeCount());
			System.out.println(cityNameAfterSearch + " " + numberOfDegree + " " + degreeOfUnit);
		} catch (Exception e) {
			throw e;
		}
	}
}