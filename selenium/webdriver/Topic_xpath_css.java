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

public class Topic_xpath_css {

	WebDriver driver;
	// http://live.demoguru99.com/index.php/mobile.html
	String url = "http://live.demoguru99.com";
	By linkMyAcount = By.xpath("//div[@class='footer']//a[@title='My Account']");
	By btnLogin = By.xpath("//button[@id='send2']");

	By messageEmail = By.xpath("//div[@id='advice-required-entry-email']");
	By messagePass = By.xpath("//div[@id='advice-required-entry-pass']");
	By messageInValidEmail=By.xpath("//div[@id='advice-validate-email-email']");
	By textboxEmail=By.xpath("//input[@id='email']");
	By textboxPass=By.xpath(" //input[@id='pass']");
	By messageInValidPass=By.xpath("//div[@id='advice-validate-password-pass']");
	By messageInvalidEmailorPass=By.xpath("//span[contains(text(),'Invalid login or password.')]");

	@BeforeTest
	public void before() {

		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// cho element dc load
		driver.manage().window().maximize();// mo full window

	}

	@AfterTest
	public void after() {
		driver.quit();
	}

	@Test
	public void TC_01() {
		driver.findElement(linkMyAcount).click();
		driver.findElement(btnLogin).click();
		String message1 = driver.findElement(messageEmail).getText();
		String message2 = driver.findElement(messagePass).getText();
		Assert.assertEquals(message1, "This is a required field.");
		Assert.assertEquals(message2, "This is a required field.");

	}

	
	public void TC_02() throws InterruptedException {
		
		
		driver.findElement(textboxEmail).clear();
		driver.findElement(textboxPass).clear();
		driver.findElement(textboxEmail).sendKeys("123434234@12312.123123");
		
		driver.findElement(textboxPass).sendKeys("123456");
		driver.findElement(btnLogin).click();
		String messageError=driver.findElement(messageInValidEmail).getText();
		Assert.assertEquals(messageError, "Please enter a valid email address. For example johndoe@domain.com.");
		Thread.sleep(5000);
	}

	
	public void TC_03() throws InterruptedException {
		
		
		driver.findElement(textboxEmail).clear();
		driver.findElement(textboxPass).clear();
		driver.findElement(textboxEmail).sendKeys("automation@gmail.com");
		
		driver.findElement(textboxPass).sendKeys("123");
		driver.findElement(btnLogin).click();
		String messageError=driver.findElement(messageInValidPass).getText();
		Assert.assertEquals(messageError, "Please enter 6 or more characters without leading or trailing spaces.");
		Thread.sleep(5000);
	}
	
	public void TC_04() throws InterruptedException {
		
		
		driver.findElement(textboxEmail).clear();
		driver.findElement(textboxPass).clear();
		driver.findElement(textboxEmail).sendKeys("automation@gmail.com");
		
		driver.findElement(textboxPass).sendKeys("123123123");
		driver.findElement(btnLogin).click();
		String messageError=driver.findElement(messageInvalidEmailorPass).getText();
		Assert.assertEquals(messageError, "Invalid login or password.");
		Thread.sleep(5000);
	}
	@Test
	public void TC_05() throws InterruptedException {
		
		
		driver.findElement(textboxEmail).clear();
		driver.findElement(textboxPass).clear();
		driver.findElement(textboxEmail).sendKeys("automation_13@gmail.com");
		
		driver.findElement(textboxPass).sendKeys("123123");
		driver.findElement(btnLogin).click();
		String  MyDashboard= driver.findElement(By.xpath(" //h1[contains(text(),'My Dashboard')]")).getText();
		Assert.assertEquals(MyDashboard, "MY DASHBOARD");
		String hello=driver.findElement(By.xpath("//strong[contains(text(),'Hello, Automation Testing!')]")).getText();
		Assert.assertEquals(hello, "Hello, Automation Testing!");
		String message=driver.findElement(By.xpath("//div[@class='box-content']//p[contains(text(),'Automation Testing')]")).getText();
		Assert.assertTrue(message.contains("Automation Testing"));
		Assert.assertTrue(message.contains("automation_13@gmail.com"));
		driver.findElement(By.xpath("//span[@class='label'][contains(text(),'Account')]")).click();
		driver.findElement(By.xpath(" //a[contains(text(),'Log Out')]")).click();
			
		Thread.sleep(5000);
	}
}
