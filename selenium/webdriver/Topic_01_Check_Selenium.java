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

public class Topic_01_Check_Selenium {

	WebDriver driver;
	//http://live.demoguru99.com/index.php/mobile.html
	String url = "https://automationfc.github.io/basic-form/";
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

	@Test
	public void TestLogin() throws InterruptedException {
		driver.get(url);
		/*
		 * String getCurrent = driver.getCurrentUrl(); Thread.sleep(5000); //
		 * System.out.println(getCurrent); String getTitle = driver.getTitle();
		 * Thread.sleep(5000); // System.out.println(getTitle); String getSource =
		 * driver.getPageSource(); // System.out.println(getSource);
		 * 
		 * String getIdWindow = driver.getWindowHandle();
		 * //System.out.println(getIdWindow);
		 * 
		 * driver.findElement(By.xpath("//a[@title='English (UK)']")).click();
		 * driver.navigate().back();
		 * 
		 * driver.navigate().forward(); Thread.sleep(5000);
		 * 
		 * driver.navigate().refresh(); Thread.sleep(5000); // driver.close();// trong
		 * truong hop mo nhieu tab, tab nao dang active thi no // dong tab active do //
		 * driver.quit(); // dong tat ca cac tab
		 * 
		 * driver.switchTo().alert(); //driver.switchTo().window("14"); // 14 la id cua
		 * window
		 */
		WebElement element;

		element = driver.findElement(email);
		Assert.assertTrue(element.isDisplayed());
		// element.click();
		 element.getCssValue("font-size");
System.out.print( element.getCssValue("font-size"));
		 System.out.print( element.getCssValue("background-color"));
		// kiem tra 1 element hien thi

//kiem tra 1 element da duoc chon: checkbox, radio button
		element = driver.findElement(checkbox);
		Assert.assertFalse(element.isSelected());

// kiem tra element ko bi disable 
		element = driver.findElement(btn2);
		Assert.assertTrue(element.isEnabled());
		// kiem tra element bi disable
		element = driver.findElement(btn1);
		Assert.assertFalse(element.isEnabled());

	}

}
