package webdriver;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Topic2 {

	WebDriver driver;
JavascriptExecutor jsScript; 
	String inputName, inputdate, outputdate, inputAddress, outputAddress, inputCity, inputState, inputPin, inputMobile,
			inputEmail, inputPasss;
	String ngay, thang, nam;
	By link = By.xpath("//a[text()='here']");
	By email = By.name("emailid");
	By btn = By.name("btnLogin");
	By checkbox = By.xpath("//input[@name='java']");

	By user = By.xpath("//td[text()='User ID :']/following-sibling::td");

	By pass = By.xpath("//td[text()='Password :']/following-sibling::td");
	By userLogin = By.name("uid");
	By passLogin = By.name("password");
	String username, password;
	String url;
	By btnLogin = By.name("btnLogin");
	By text = By.xpath("//marquee[@class='heading3']");
	By createAccount = By.xpath(" //a[(text()='New Customer')]");
	By CustomerName = By.xpath(" //input[@name='name']");
	By gender = By.xpath("//input[@value='f']");
	By date = By.name("dob");
	By Address = By.xpath("//textarea[@name='addr']");
	By city = By.xpath("//input[@name='city']");
	By state = By.xpath("//input[@name='state']");
	By pin = By.xpath("//input[@name='pinno']");
	By Mobile = By.xpath(" //input[@name='telephoneno']");
	By emalCreate = By.xpath("//input[@name='emailid']");
	By passCreate = By.xpath("//input[@name='password']");
	By submit = By.xpath(" //input[@name='sub']");
	By messageSuccess = By.xpath("//p[@class='heading3']");
	By verifyCustomerName = By.xpath("//td[(text()='Customer Name')]/following-sibling::td");
	By verifyAdd = By.xpath("//td[(text()='Address')]/following-sibling::td");

	@BeforeTest
	public void before() {
       String dir=System.getProperty("user.dir");
       System.out.println (dir);
		// System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// cho element dc load
		driver.manage().window().maximize();// mo full window
		driver.get("http://demo.guru99.com/v4/");
		// khoi tao data test

	}

	@AfterTest
	public void after() {
		driver.quit();
	}

	@Test(priority = 1)
	public void registration() throws InterruptedException {

		url = driver.getCurrentUrl();

		WebElement element;

		element = driver.findElement(link);

		element.click();

		element = driver.findElement(email);
		element.sendKeys("thuytest54@gmail.com");
		element = driver.findElement(btn);
		element.click();
		Thread.sleep(5000);

		element = driver.findElement(user);
		username = element.getText();
		System.out.println(username);

		element = driver.findElement(pass);
		password = element.getText();
		System.out.println(password);
	}

	@Test(priority = 2)
	public void Login() throws InterruptedException {

		driver.get(url);
		Thread.sleep(10000);
		WebElement element;
		element = driver.findElement(userLogin);
		element.sendKeys(username);

		element = driver.findElement(passLogin);
		element.sendKeys(password);
		element = driver.findElement(btnLogin);
		element.click();

		element = driver.findElement(text);
		String verifyText = element.getText();
		Assert.assertEquals(verifyText, "Welcome To Manager's Page of Guru99 Bank");

	}

	@Test(priority = 3)
	public void creat() throws InterruptedException {
		WebElement element;
		inputName = "vu phuong thuy";
		ngay = "16";
		thang = "06";
		nam = "1986";
		inputdate = thang + "/" + ngay + "/" + nam;
		outputdate = thang + "-" + ngay + "-" + nam;
		inputAddress = "vu phuong thuy \n abc";
		// outputAddress=inputAddress.replace("\n", "")
		inputCity = "vu phuong thuy";
		inputState = "vu phuong thuy";
		inputPin = "123456";
		inputMobile = "123456789";
		inputEmail = "vuthuy" + getRandomNumber() + "@gmail.com";
		inputPasss = "123456";

		element = driver.findElement(createAccount);

		element.click();

		element = driver.findElement(CustomerName);

		element.sendKeys(inputName);

		// element=driver.findElement(gender);

		// element.click();
		Thread.sleep(5000);
		removeAttributeInDOM("//input[@name='dob']", "type");
		driver.findElement(date).sendKeys(inputdate);
		Thread.sleep(5000);
		/*
		 * element=driver.findElement(Address);
		 * 
		 * element.sendKeys(inputAddress); element=driver.findElement(city);
		 * 
		 * element.sendKeys(inputCity); element=driver.findElement(state);
		 * 
		 * element.sendKeys(inputState); element=driver.findElement(pin);
		 * 
		 * element.sendKeys(inputPin); element=driver.findElement(Mobile);
		 * 
		 * element.sendKeys(inputMobile); element=driver.findElement(emalCreate);
		 * 
		 * element.sendKeys(inputEmail); element=driver.findElement(passCreate);
		 * 
		 * element.sendKeys(inputPasss);
		 * 
		 * element=driver.findElement(submit);
		 * 
		 * element.click(); Thread.sleep(10000);
		 * 
		 * // element=driver.findElement(messageSuccess); // String
		 * mess=element.getText();
		 * //Assert.assertEquals(mess,"Customer Registered Successfully!!!");
		 * //element=driver.findElement(verifyAdd);
		 * //Assert.assertEquals(element.getText(),"");
		 */
	}

	public int getRandomNumber() {
		Random random = new Random();

		return random.nextInt(999999);
	}
	
	public void removeAttributeInDOM( String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}
}
