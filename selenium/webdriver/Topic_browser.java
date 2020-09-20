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

public class Topic_browser {

	WebDriver driver;
	//http://live.demoguru99.com/index.php/mobile.html
	String url = "http://live.demoguru99.com/";
	By email = By.id("mail");
	By btn1 = By.id("button-disabled");
	By btn2 = By.id("button-enabled");
	By checkbox = By.xpath("//input[@name='java']");
	

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
		driver.findElement( By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.demoguru99.com/index.php/customer/account/login/");
	
	  driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
	  Assert.assertEquals(driver.getCurrentUrl(),"http://live.demoguru99.com/index.php/customer/account/create/");
	}

	
	public void TC_02() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement( By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		Assert.assertEquals(driver.getTitle(),"Customer Login");
	
	  driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
	  Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
	}
	@Test
	public void TC_03() {
		driver.get("http://live.demoguru99.com/");
		driver.findElement( By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
		driver.navigate().back();

		Assert.assertEquals(driver.getCurrentUrl(),"http://live.demoguru99.com/index.php/customer/account/login/");
		driver.navigate().forward(); 
		 Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
	}
}
