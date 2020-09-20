package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic_Element {

	WebDriver driver;
	// http://live.demoguru99.com/index.php/mobile.html
	String url = "https://automationfc.github.io/basic-form/";

	@BeforeTest
	public void before() {

		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// cho element dc load
		driver.manage().window().maximize();// mo full window

	}

	@AfterTest
	public void after() {
		driver.quit();
	}

	public void TC_01() {
		driver.get(url);

		if (driver.findElement(By.xpath("//input[@id='mail']")).isDisplayed()) {
			driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("a@b.c");
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element isn't displayed");
		}

		if (driver.findElement(By.xpath(" //label[contains(text(),'Under 18')]")).isDisplayed()) {
			driver.findElement(By.xpath("//label[contains(text(),'Under 18')]")).click();
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element isn't displayed");

		}

		if (driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed()) {
			driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("abc \n def");
			System.out.println("Element is displayed");
		} else {
			System.out.println("Element isn't displayed");

		}
	}

	public void TC_02() {
		driver.get(url);

		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='mail']")).isEnabled()) ;
		Assert.assertTrue(driver.findElement(By.xpath(" //label[contains(text(),'Under 18')]")).isEnabled()) ;

		Assert.assertTrue(driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled());

		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='password']")).isEnabled()) ;
		

	}
@Test
	public void TC_03() throws InterruptedException {
		driver.get(url);

		driver.findElement(By.xpath(" //input[@id='under_18']")).click();
		Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='under_18']")).isSelected());
	}
}
