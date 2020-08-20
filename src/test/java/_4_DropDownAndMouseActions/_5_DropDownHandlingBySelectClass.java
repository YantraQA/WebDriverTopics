package _4_DropDownAndMouseActions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class _5_DropDownHandlingBySelectClass {
	
	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		
		WebElement createNewAccountButton = driver.findElement(By.xpath("//a[@role='button' and text()='Create New Account']"));
		createNewAccountButton.click();
		WebElement birthDay = driver.findElement(By.id("day"));
		WebElement birthMonth = driver.findElement(By.id("month"));
		WebElement birthYear = driver.findElement(By.id("year"));
		
		Select daySelect = new Select(birthDay);
		daySelect.selectByVisibleText("3");
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(2000);
		
		Select monthSelect = new Select(birthMonth);
		monthSelect.selectByVisibleText("Sep");
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(2000);
		
		Select yearSelect = new Select(birthYear);
		yearSelect.selectByVisibleText("2014");
		
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)s
		Thread.sleep(3000);
		driver.quit();
	}

}
