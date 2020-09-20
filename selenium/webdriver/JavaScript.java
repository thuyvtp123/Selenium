package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScript {
	WebDriver driver;

	String url = "https://jqueryui.com/resources/demos/selectmenu/default.html";

	@BeforeTest
	public void before() {

		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
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
	public void Verify() throws InterruptedException {

		clickToElementByJS("//div[@id='ui-id-8']");

		Thread.sleep(5000);

	}

	public void clickToElementByJS(String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

}
