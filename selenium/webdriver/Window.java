package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Window {
	public WebDriver driver;
	WebDriverWait explicitWait;
	By btnLogin = By.xpath("//div[@class='btn-group']//button[@type='button']");

	By btnLoginGoogle = By.xpath("//span[contains(text(),'Sign In with Google')]");

	By interationGuideline = By.xpath("//button[contains(text(),'Integration guideline')]");
	By docViewer = By.xpath("//button[contains(text(),'Go to API doc viewer')]");
	By signOut = By.xpath("//button[contains(text(),'Sign Out')]");
	By placeHolder = By.xpath("//input[@placeholder='Search apis contain (full text)...']");
	By btnExplore = By.xpath("//button[@class='btn btn-primary']");
	By message = By.xpath("//h4[contains(text(),'No API definition provided.')]");

	String parentID;
	String url = "http://atlantis.dev.tiki.services/";

	@BeforeTest
	public void before() {

		// System.setProperty("webdriver.gecko.driver", "chromedriver.exe");
		// driver = new FirefoxDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);// cho element dc load
		driver.manage().window().maximize();// mo full window
		driver.get(url);
		// khoi tao data test≈

	}

	@AfterTest
	public void after() {
		driver.quit();
	}

	// @Test(priority=1)
	public void VerifyLoginSuccess() throws InterruptedException {
		parentID = driver.getWindowHandle();

		driver.findElement(btnLogin).click();

		driver.findElement(btnLoginGoogle).click();

		/**
		 * how-to-switch-to-popup-window-using
		 */

		System.out.println("current" + parentID);
		switchToWindowbyID(parentID);

		WebElement email = driver.findElement(By.id("identifierId"));
		email.sendKeys("thuytest38@gmail.com");
		WebElement btnNext1 = driver.findElement(By.xpath("//div[@id='identifierNext']/div/button/div[2]"));
		btnNext1.click();

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123456");
		WebElement btnNext2 = driver.findElement(By.xpath("//div[@id='passwordNext']/div/button/div[2]"));
		btnNext2.click();

		Thread.sleep(5000);

		// Assert.assertTrue(isAllWindowCloseWithoutParent(parentID));
		isAllWindowCloseWithoutParent(parentID);

		Assert.assertEquals(
				driver.findElement(By.xpath("//button[contains(text(),'Thuy (Engineer). Vu Thi Phuong')]")).getText(),
				"Thuy (Engineer). Vu Thi Phuong");

	}

	public void VerifyPlaceholder() {
		String string = driver.findElement(placeHolder).getAttribute("placeholder");
		System.out.print(string);
		Assert.assertEquals(string, "Search apis contain (full text)...");
	}

	public void VerifyNavigatePageinterationGuideline() {
		driver.findElement(By.xpath("//button[contains(text(),'Thuy (Engineer). Vu Thi Phuong')]")).click();
		driver.findElement(interationGuideline).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://atlantis.dev.tiki.services/guide-line");

	}

	public void VerifyNavigatePagedocViewer() {
		driver.findElement(By.xpath("//button[contains(text(),'Thuy (Engineer). Vu Thi Phuong')]")).click();
		driver.findElement(docViewer).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://atlantis.dev.tiki.services/api-doc-view");

	}

	public void VerifyWithoutData() throws InterruptedException {
		driver.findElement(btnExplore).click();
		driver.findElement(message).getText();
		Assert.assertEquals(driver.findElement(message).getText(), "No API definition provided.");
		Thread.sleep(5000);
	}

	public void Verify_Atlantis_Link() throws InterruptedException {
		driver.findElement(By.xpath("//h2[contains(text(),'Atlantis')]")).click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), "http://atlantis.dev.tiki.services/");

	}

	public void VerifyWithoutSearchResult() throws InterruptedException {
		driver.findElement(placeHolder).sendKeys("@#$%^&");
		Thread.sleep(5000);
		List<WebElement> allItem = driver.findElements(By.xpath("//div[@class='list-group']/button"));
		allItem.size();
		System.out.print("Size" + allItem.size());
		Assert.assertEquals(allItem.size(), 0);

	}

	// @Test(priority=2)
	public void VerifySearch() throws InterruptedException {
		driver.findElement(placeHolder).clear();
		driver.findElement(placeHolder).sendKeys("create");
		Thread.sleep(5000);
		List<WebElement> allItem = driver.findElements(By.xpath("//div[@class='list-group']/button"));
		allItem.size();
		System.out.print("Size" + allItem.size());
		for (WebElement item : allItem) {
			String itemText = item.getText().trim();
			System.out.println(itemText);
			Assert.assertTrue(itemText.contains("create"));
		}

	}

	// @Test(priority=2)
	public void VerifySelectItemInSearchResult() throws InterruptedException {
		// driver.findElement(placeHolder).clear();
		driver.findElement(placeHolder).sendKeys("create");
		Thread.sleep(5000);
		// explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='list-group']/button")));

		List<WebElement> allItem = driver.findElements(By.xpath("//div[@class='list-group']/button"));

		for (WebElement item : allItem) {
			item.click();
			System.out.print(driver.getCurrentUrl());
			Assert.assertTrue(driver.getCurrentUrl().contains("http://atlantis.dev.tiki.services/apis?id="));

			Thread.sleep(5000);//chi muốn click hết vào các giá trị show rasau khi search xong ấy em, mà do click vào giá trị nsó chuyển page khác ên chạy sang thang tiep theo bịiail
			break;
		}
	}

	public void VerifySignOut() {
		driver.findElement(By.xpath("//button[contains(text(),'Thuy (Engineer). Vu Thi Phuong')]")).click();
		driver.findElement(signOut).click();
		Assert.assertEquals(driver.findElement(btnLogin).getText(), "Sign In (tikier)");

	}

	@Test
	public void VerifyLoginFail() throws InterruptedException {
		parentID = driver.getWindowHandle();

		driver.findElement(btnLogin).click();

		driver.findElement(btnLoginGoogle).click();

		/**
		 * how-to-switch-to-popup-window-using
		 */

		System.out.println("current" + parentID);
		switchToWindowbyID(parentID);

		WebElement email = driver.findElement(By.id("identifierId"));
		email.sendKeys("doan.thuy.huong@sun-asterisk.com");
		WebElement btnNext1 = driver.findElement(By.xpath("//div[@id='identifierNext']/div/button/div[2]"));
		btnNext1.click();
		Thread.sleep(5000);

		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("123456");
		WebElement btnNext2 = driver.findElement(By.xpath("//div[@id='passwordNext']/div/button/div[2]"));
		btnNext2.click();

		Thread.sleep(5000);
		String string = driver.findElement(By.xpath("//span[contains(text(),'Authorization Error')]")).getText();

		Assert.assertEquals(string, "Authorization Error");

	}

	public void switchToWindowbyID(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public boolean isAllWindowCloseWithoutParent(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

}
