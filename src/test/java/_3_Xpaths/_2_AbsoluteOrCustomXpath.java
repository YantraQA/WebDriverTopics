package _3_Xpaths;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_AbsoluteOrCustomXpath {

	WebDriver driver;

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in");
	}
	
	
	@Test
	public void searchboxTest() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchBox.sendKeys("iphone");
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);

		WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit' and @class='nav-input']"));
		searchButton.click();
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		
		WebElement searchResult = driver.findElement(By.xpath("//div/span[contains(text(),'iphone')]"));
		
		
		// Validation
		
		// Option 1
		String searchResultText = searchResult.getText();
		Assert.assertEquals("\"iphone\"", searchResultText);
		
		// Option 2
//		Assert.assertEquals("\"iphone\"", searchResult.getText());

		
	}

	@After
	public void teardown()
	{
		driver.quit();
	}

}
