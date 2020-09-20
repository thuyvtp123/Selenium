package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkbox_Custom {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String url = "https://material.angular.io/components/checkbox/examples";
	By Checkbox = By.xpath("//span[contains(text(),'Checked')]/preceding-sibling::div");
// chú ý : case này nếu lấy theo thẻ div thì sẽ ko bao giờ verify đúng do div luôn luôn trả về false
	By Checkbox1= By.xpath("//span[contains(text(),'Checked')]/preceding-sibling::div/input");
	@BeforeTest
	public void before() {

		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;





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
	public void verify() throws InterruptedException {

		clickByJavascript(driver.findElement(Checkbox1));
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(Checkbox1).isSelected());

	}

	public void clickByJavascript(WebElement element) {
		jsExecutor.executeScript("arguments[0].click()", element);

	}

}
