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



public class _1_AbsoluteXpath {
	
	WebDriver driver;
	
	String pageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void validateTitleTest()
	{	
		
		Assert.assertEquals("Title is not matching", pageTitle, driver.getTitle());
		System.out.println("Test Case is pass");
	}
	
	@Test
	public void searchboxItem() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[2]/div[1]/input"));
		searchBox.sendKeys("iphone");
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		
		WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[1]/div[2]/div/form/div[3]/div/span/input"));
		searchButton.click();
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}

}
