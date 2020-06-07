package WebTableDemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.Flipkart.Utils.SeleniumUtils;

public class WebTableDemo {

	static WebDriver driver;
	
	static By HANDLE_WEB_SELENIUM_TEXT=By.xpath("//table[@name='BookTable']//tr[1]");
	static By ROW_NUMBER_OF_TABLE=By.xpath("//table[@name='BookTable']//tr");
	static By COL_NUMBER_OF_TABLE=By.xpath("//table[@name='BookTable']//tr[2]//td");

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/Resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
		driver.get("http://makeseleniumeasy.com/2017/07/14/how-to-handle-a-web-table-in-selenium-webdriver/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='fancybox_ns-close']")).click();
		Thread.sleep(2000);
		SeleniumUtils.scrollToViewElement(driver, HANDLE_WEB_SELENIUM_TEXT);
		Thread.sleep(2000);
		/***
		 * Below will get the total count of row of table
		 */
		List<WebElement> totalRow=driver.findElements(ROW_NUMBER_OF_TABLE);
		int rowCount=totalRow.size();
		System.out.println("Total row present : " + rowCount); //Total row present : 7
		
		/***
		 * Below will get the total count of column of table
		 */
		List<WebElement> totalColumn=driver.findElements(COL_NUMBER_OF_TABLE);
		int colCount=totalColumn.size();
		System.out.println("Total column present : " + colCount); //Total column present : 4
		
		for(int i=2;i<=rowCount;i++)
		{
			for(int j=1;j<=colCount;j++)
			{
				WebElement element=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]"));
				String text=element.getText();
				if(j !=colCount)
				{
					System.out.print(text+ " | " + " ");
				}
				else
				{
					System.out.print(text);
				}
			}
			System.out.println();
		}
		/***
		 * Below are OutPut
		 * Learn Selenium |  Amit |  Selenium |  300
           Learn Java |  Mukesh |  Java |  500
           Learn JS |  Animesh |  Javascript |  300
           Master In Selenium |  Mukesh |  Selenium |  3000
           Master In Java |  Amod |  JAVA |  2000
           Master In JS |  Amit |  Javascript |  1000

		 */
		
	}

}
