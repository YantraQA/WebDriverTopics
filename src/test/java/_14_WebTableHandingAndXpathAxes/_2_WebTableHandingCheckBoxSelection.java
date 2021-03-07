package _14_WebTableHandingAndXpathAxes;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _2_WebTableHandingCheckBoxSelection {
	
//	String userName = "Koushik";
//	String userName = "Yashwanth1";
	String userName = "Iron";
	
	static WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://letcode.in/table");
	}
	
	@Test
	public void _2_WebTableHandingExample()
	{
		// finding the check box for the user with given name
		try 
		{
			WebElement checkboxForUser = driver.findElement(By.xpath("//td[text()='"+userName+"']//parent::tr//td//input[@type='checkbox']"));
			checkboxForUser.click();
			Assert.assertTrue(checkboxForUser.isSelected());
			System.out.println("Checkbox for user \""+userName+"\" is selected");
			
		} catch (Exception e) 
		{
			System.err.println("Unable to findout the username: " + userName + " in the table");
			e.printStackTrace();
			e.getMessage();	
		}	
		
	}

	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

}
