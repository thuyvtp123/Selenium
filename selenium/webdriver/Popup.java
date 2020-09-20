package webdriver;

import java.util.Set;
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

public class Popup {
	 WebDriver driver;
	By btnLogin = By.xpath("//span[text()='Đăng nhập']");

	By btnLoginGoogle = By.xpath("//button[text()='Đăng nhập']");

	
	String url = "http://tala.xyz";

	@BeforeTest
	public void before() {

		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// cho element dc load
		driver.manage().window().maximize();// mo full window
		driver.get(url);
		// khoi tao data test≈

	}

	@AfterTest
	public void after() {
		driver.quit();
	}

	@Test
	public void Verify() throws InterruptedException {
		
		driver.findElement(btnLogin).click();

		driver.findElement(btnLoginGoogle).click();

		
		

		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		email.sendKeys("thuyvu@gmail.com");
		

		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("123456");
		WebElement btnNext2 = driver.findElement(By.xpath("//button [@class='UserModalstyle__RightButton-tngk37-8 GBpke']"));
		btnNext2.click();
		Thread.sleep(5000);
		WebElement user= driver.findElement(By.xpath("//span[text()='Chào Thuy VU']"));
		
		
		
		//Assert.assertTrue(isAllWindowCloseWithoutParent(parentID));
		//isAllWindowCloseWithoutParent(parentID);
		Assert.assertEquals(user.getText(), "Chào Thuy VU");

	}

	

}
