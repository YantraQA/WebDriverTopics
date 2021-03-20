package _17_HashMapUseCase;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class _1_LoginToApplication {

	static WebDriver driver;

	String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
	}


	@Test
	public void _1_LoginWithAdmin() throws InterruptedException
	{
		driver.findElement(By.id("email")).sendKeys(appCredentials().get("Admin").split("_")[0]);
		driver.findElement(By.id("passwd")).sendKeys(appCredentials().get("Admin").split("_")[1]);
		driver.findElement(By.id("SubmitLogin")).click();

		Thread.sleep(4000);

		Assert.assertEquals("Tom Peter", driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText());
		
		Thread.sleep(2000);
	}

	@Test
	public void _2_LoginWithManger() throws InterruptedException
	{
		driver.findElement(By.id("email")).sendKeys(appCredentials().get("Manager").split("_")[0]);
		driver.findElement(By.id("passwd")).sendKeys(appCredentials().get("Manager").split("_")[1]);

		driver.findElement(By.id("SubmitLogin")).click();

		Thread.sleep(4000);

		Assert.assertEquals("John Tyson", driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText());
		
		Thread.sleep(2000);
	}

	@Test
	public void _3_LoginWithEndUser() throws InterruptedException
	{
		driver.findElement(By.id("email")).sendKeys(appCredentials().get("Enduser").split("_")[0]);
		driver.findElement(By.id("passwd")).sendKeys(appCredentials().get("Enduser").split("_")[1]);
		driver.findElement(By.id("SubmitLogin")).click();

		Thread.sleep(4000);

		Assert.assertEquals("Steve Johnson", driver.findElement(By.xpath("//a[@title='View my customer account']/span")).getText());
		
		Thread.sleep(2000);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}


	public static Map<String, String> appCredentials()
	{
		Map<String, String> credentials = new HashMap<String,String>();

		// Adding values to decleared HashMap with key as application authorization level and value as username and password "_" seperated
		credentials.put("Admin", "dsfsfsdfds11@gmail.com_123456"); // Tom Peter
		credentials.put("Manager", "dsfsfsdfds12@gmail.com_123456"); // John Tyson
		credentials.put("Enduser", "dsfsfsdfds13@gmail.com_123456"); // Steve Johnson

		return credentials;
	}

}
