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


public class Alert_authen {
	
	WebDriver driver;


	

	@BeforeTest
	public void before() {

		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// cho element dc load
		driver.manage().window().maximize();// mo full window
		
		// khoi tao data test

	}

	@AfterTest
	public void after() {
		driver.quit();
	}

	@Test
	public void Login() throws InterruptedException {

		String user= "admin";
		String pass="admin";
		driver.get("http://"+user+":"+pass+"@"+"the-internet.herokuapp.com/basic_auth");
		
		Thread.sleep(10000);
		
}
}
