package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkbox {
	WebDriver driver;

	
	String url = "https://automationfc.github.io/multiple-fields/";
By allCheckbox =By.xpath("//input[@type='checkbox']");
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
	public void Login() throws InterruptedException {
List<WebElement> checkboxes=driver.findElements(allCheckbox);
		
for (WebElement checkbox : checkboxes)
{
	checkbox.click();
}
//verify
for (WebElement checkbox : checkboxes)
{
	Assert.assertFalse(checkbox.isSelected());
}
		
		Thread.sleep(5000);
		
		
		
}

}
