package webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class droplist2 {
	Select select;// luu y: Select chi ho tro cho the select> option
	WebDriver driver;
//	By droplist = By.xpath("//select[@title='Results per page']");
By droplist=By.xpath("//select[@id='job1']//option[@value='manual']");
	
	String url = "https://automationfc.github.io/basic-form/";

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

		WebElement element;
		element = driver.findElement(droplist);
	element.click();
	Thread.sleep(10000);
		//select = new Select(element);
		//kiem tra xem listbox co select multiple duoc ko
		//Assert.assertFalse(select.isMultiple());
		//select.selectByVisibleText("24");// select 1 gia tri trong listbox
		//Assert.assertEquals(select.getFirstSelectedOption().getText(), "24");// verify da select duoc gia tri
		// dem trong listbox co bao nhieu gia tri
		//List<WebElement> option= select.getOptions();
		//option.size();
		//in ra cac gia tri trong listbox-> cach 1
		/*for (int i=0;i<option.size();i++)
		{
		System.out.println(option.get(i).getText());
		}
		//cach 2
		for(WebElement i : option )
		{
			System.out.print(i.getText());
		}
*/
		/*
		ArrayList<String> actual =new ArrayList<String>();
		actual.add("12");
		actual.add("24");
		actual.add("36");
		ArrayList<String> expected =new ArrayList<String>();
		for(WebElement i : option )
		{
			System.out.print(i.getText());
		}
		Assert.assertEquals(actual, expected);
		
		*/
		
	}
}