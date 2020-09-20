package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class droplist_custom {

	WebDriver driver;
	// By iconDroplist = By.xpath("//span[@id='number-button']");

	// By itemInDroplist=By.xpath("//div[@id='ui-id-8']");
	String url = "https://jqueryui.com/resources/demos/selectmenu/default.html";
	WebDriverWait explicitWait;

	@BeforeTest
	public void before() {

		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// cho element dc load
		driver.manage().window().maximize();// mo full window
		driver.get(url);
		// khoi tao data test

	}

	@AfterTest
	public void after() {
		driver.quit();
	}

	@Test
	public void DropList_Jquery() {

		selectItem("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "5");
		selectItem("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "6");
		selectItem("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "7");
		selectItem("//span[@id='number-button']", "//li[@class='ui-menu-item']/div", "8");

		Assert.assertTrue(driver
				.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text' and text()='5']"))
				.isDisplayed());

	}

	

	public void selectItem(String parentLocator, String itemLocator, String expectedItem) {
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(parentLocator)));
		driver.findElement(By.xpath(parentLocator)).click();
		sleepSecond(1);
		// cho cho cac item co trong DOM
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(itemLocator)));
		List<WebElement> allItems = driver.findElements(By.xpath(itemLocator));
		for (WebElement item : allItems) {
			if (item.getText().equals(expectedItem)) {
				explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(parentLocator)));
				item.click();
				sleepSecond(2);
				break;
			}
		}
	}

	public void sleepSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickToElementByJS(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

}
