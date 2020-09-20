package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Alert {
	
	WebDriver driver;

	org.openqa.selenium.Alert alert;
	String url = "http://demo.guru99.com/v4";
By btn=By.xpath("//input[@name='btnLogin']");
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

		driver.findElement(btn).click();
		alert= driver.switchTo().alert();
		alert.getText();
		alert.accept();
		//alert.sendKeys("");
		Thread.sleep(5000);
		//alert.dismiss();
		
		
}
}
