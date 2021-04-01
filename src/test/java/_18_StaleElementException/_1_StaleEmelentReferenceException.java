package _18_StaleElementException;

import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_StaleEmelentReferenceException {
	
	static WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	
	@Before
	public void setup() throws AWTException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.navigate().to(url);
	}
	
//	@Test
//	public void _1_TestToBeFailed()
//	{
//		WebElement signInButtonElement = driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
//		
//		System.out.println("Sign In Button Text Is on First Time -> " + signInButtonElement.getText());
//		
//		signInButtonElement.click();
//		
//		driver.navigate().back();
//		
//		System.out.println("Sign In Button Text Is after get back from SignIn Page -> " + signInButtonElement.getText());
//		
//	}
//	
//	@Test
//	public void _2_TestToBeFailed()
//	{
//		WebElement signInButtonElement = driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
//		
//		System.out.println("Sign In Button Text Is -> " + signInButtonElement.getText());
//		
//		driver.navigate().refresh();
//		
//		System.out.println("Sign In Button Text Is -> " + signInButtonElement.getText());
//		
//	}
	
	@Test
	public void _3_TestToBePassed()
	{
		try 
		{
			WebElement signInButtonElement = driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
			
			System.out.println("Sign In Button Text Is -> " + signInButtonElement.getText());
			
			signInButtonElement.click();
			
			driver.navigate().back();
			
			System.out.println("Sign In Button Text Is -> " + signInButtonElement.getText());
			
		}
		catch (Exception e) 
		{
			WebElement signInButtonElement = driver.findElement(By.xpath("//div[@class='header_user_info']/a"));
			System.out.println("Sign In Button Text Is -> " + signInButtonElement.getText());
		}
		
	}
	
	
	@After
	public void tearDown() throws InterruptedException
	{
		driver.quit();
	}

}
