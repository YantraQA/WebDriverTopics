package _6_DesiredCapabilitiesSynchronisationToolTip;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _4_Synchronisation {
	
	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setUp()
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://app.hubspot.com/");
		
		wait = new WebDriverWait(driver, 15);
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		
		WebElement userNameFiled = driver.findElement(By.id("username"));
		userNameFiled.sendKeys("hobiy94180@banetc.com");
		
		WebElement passwordFiled = driver.findElement(By.id("password"));
		passwordFiled.sendKeys("123@Abc.");
		
		WebElement logInButton = driver.findElement(By.id("loginBtn"));
		logInButton.click();
		
		System.out.println("Page Title after login is : " + driver.getTitle());
		
		wait.until(ExpectedConditions.titleContains("| HubSpot"));
		
		System.out.println("Page Title after login is : " + driver.getTitle());
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}

}
