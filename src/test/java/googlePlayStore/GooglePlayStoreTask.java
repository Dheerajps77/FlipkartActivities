package googlePlayStore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.Flipkart.Utils.SeleniumUtils;

public class GooglePlayStoreTask {

	private static final int WAIT_SECONDS = Integer.valueOf(SeleniumUtils.fetchUserDetails("GLOBAL_WAIT"));

	public final By APP_BTN = By.xpath("//ul[@class='XBXPXc wEDdvc']//li[2]//a/child::span[1]/span[2]");
	public final By CATEGORY_BTN = By.xpath("//div[@class='JRhuKe']//button");

	public WebElement appButton() {
		return SeleniumUtils.waitForElementPresence(driver, APP_BTN, WAIT_SECONDS);
	}

	public WebElement categoryButton() {
		return SeleniumUtils.waitForElementPresence(driver, CATEGORY_BTN, WAIT_SECONDS);
	}

	WebDriver driver;

	@BeforeSuite
	public void initiateBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/Resources/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
			driver.get("https://play.google.com/store");
		} catch (Exception e) {
			throw e;
		}
	}

	public ArrayList<String> getListOfArtAndDesignUnderCategorySections() throws Exception {
		List<WebElement> artAndDesignElement;
		int totalCountOfArtAndDesignElement;

		ArrayList<String> arraylist = new ArrayList<String>();
		try {
			artAndDesignElement = driver.findElements(By.xpath(
					"//div[@id='action-dropdown-children-Categories']//div[@class='LNKfBf']//ul//li[1]//ul/li//a"));
			totalCountOfArtAndDesignElement = artAndDesignElement.size();
			for (int i = 2; i <= totalCountOfArtAndDesignElement; i++) {
				WebElement element = driver.findElement(By
						.xpath("//div[@id='action-dropdown-children-Categories']//div[@class='LNKfBf']//ul//li[1]//ul/li["
								+ i + "]//a"));
				String textOfElement = element.getText();
				arraylist.add(textOfElement);
				element.click();
				Thread.sleep(4000);
				System.out.println("Clicked On : " + textOfElement);
				Thread.sleep(4000);				
				WebElement checkIfElementIsStale=SeleniumUtils.staleElementHandle(driver, element, CATEGORY_BTN);
				checkIfElementIsStale.click();
			}
		} catch (Exception e) {
			throw e;
		}
		return arraylist;
	}

	public ArrayList<String> getListOfGamesUnderCategorySections() {
		List<WebElement> artAndDesignElement;
		int totalCountOfArtAndDesignElement;

		ArrayList<String> arraylist = new ArrayList<String>();
		try {
			artAndDesignElement = driver.findElements(By.xpath(
					"//div[@id='action-dropdown-children-Categories']//div[@class='LNKfBf']//ul//li[2]//ul/li//a"));
			totalCountOfArtAndDesignElement = artAndDesignElement.size();
			for (int i = 3; i <= totalCountOfArtAndDesignElement; i++) {
				WebElement element = driver.findElement(By
						.xpath("//div[@id='action-dropdown-children-Categories']//div[@class='LNKfBf']//ul//li[2]//ul/li["
								+ i + "]//a"));
				String textOfElement = element.getText();
				arraylist.add(textOfElement);
			}
		} catch (Exception e) {
			throw e;
		}
		return arraylist;
	}

	public ArrayList<String> getListOfFamilyUnderCategorySections() {
		List<WebElement> artAndDesignElement;
		int totalCountOfArtAndDesignElement;

		ArrayList<String> arraylist = new ArrayList<String>();
		try {
			artAndDesignElement = driver.findElements(By.xpath(
					"//div[@id='action-dropdown-children-Categories']//div[@class='LNKfBf']//ul//li[3]//ul/li//a"));
			totalCountOfArtAndDesignElement = artAndDesignElement.size();
			for (int i = 3; i <= totalCountOfArtAndDesignElement; i++) {
				WebElement element = driver.findElement(By
						.xpath("//div[@id='action-dropdown-children-Categories']//div[@class='LNKfBf']//ul//li[3]//ul/li["
								+ i + "]//a"));
				String textOfElement = element.getText();
				arraylist.add(textOfElement);
			}
		} catch (Exception e) {
			throw e;
		}
		return arraylist;
	}

	@Test
	public void clickOnEachListValue() throws Exception
	{
			ArrayList<String> artAndDesignList=new ArrayList<String>();
				ArrayList<String> gamesList=new ArrayList<String>();
				ArrayList<String> familyList=new ArrayList<String>();
				try {
					if (appButton().isDisplayed() || appButton().isEnabled()) {
						SeleniumUtils.waitForElementClickable(driver, APP_BTN, 30);
						appButton().click();
						//Thread.sleep(4000);
						SeleniumUtils.waitForElementClickable(driver, CATEGORY_BTN, 30);
						categoryButton().click();
						//Thread.sleep(4000);
						artAndDesignList=getListOfArtAndDesignUnderCategorySections();
						System.out.println("Total Size of app present under Art & Design Category is : "+ artAndDesignList.size());						
						
						/*
						for(int i=1;i<=artAndDesignList.size();i++)
						{
							System.out.println(artAndDesignList.get(i));
						}
						
						System.out.println("=======================================================================");
						gamesList=getListOfGamesUnderCategorySections();
						System.out.println("Total Size of app present under Art & Design Category is : "+ gamesList.size());
						for(int i=1;i<=gamesList.size();i++)
						{
							System.out.println(gamesList.get(i));
						}
						
						System.out.println("=======================================================================");				
						familyList=getListOfFamilyUnderCategorySections();				
						System.out.println("Total Size of app present under Art & Design Category is : "+ familyList.size());
						for(int i=1;i<=familyList.size();i++)
						{
							System.out.println(familyList.get(i));
						}
						*/
					}
				}
					catch (Exception e) {
			throw e;
		}
	}
	//@Test
	public void AppUnderCategorySections() throws Exception {
		ArrayList<String> artAndDesignList=new ArrayList<String>();
		ArrayList<String> gamesList=new ArrayList<String>();
		ArrayList<String> familyList=new ArrayList<String>();
		try {
			if (appButton().isDisplayed() || appButton().isEnabled()) {
				SeleniumUtils.waitForElementClickable(driver, APP_BTN, 30);
				appButton().click();
				//Thread.sleep(4000);
				SeleniumUtils.waitForElementClickable(driver, CATEGORY_BTN, 30);
				categoryButton().click();
				//Thread.sleep(4000);
				artAndDesignList=getListOfArtAndDesignUnderCategorySections();
				System.out.println("Total Size of app present under Art & Design Category is : "+ artAndDesignList.size());
				for(int i=1;i<=artAndDesignList.size();i++)
				{
					System.out.println(artAndDesignList.get(i));
				}
				
				System.out.println("=======================================================================");
				gamesList=getListOfGamesUnderCategorySections();
				System.out.println("Total Size of app present under Art & Design Category is : "+ gamesList.size());
				for(int i=1;i<=gamesList.size();i++)
				{
					System.out.println(gamesList.get(i));
				}
				
				System.out.println("=======================================================================");				
				familyList=getListOfFamilyUnderCategorySections();				
				System.out.println("Total Size of app present under Art & Design Category is : "+ familyList.size());
				for(int i=1;i<=familyList.size();i++)
				{
					System.out.println(familyList.get(i));
				}
				
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
