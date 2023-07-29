package Session_13;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _1_HashMapUseCase {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarang\\eclipse-workspace\\Batch - 21\\SeleniumWebDriverB21\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Users\\Sarang\\eclipse-workspace\\Batch - 21\\chrome-win64\\chrome-win64\\chrome.exe");
		driver = new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.saucedemo.com/");
	}
		
	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	public void validUser()
	{
		
		WebElement usernameFieldEle = driver.findElement(By.xpath("//input[@id='user-name']"));
		String validusername = appCred().get("validUser").split("#")[0];
		System.out.println(validusername);
		usernameFieldEle.sendKeys(validusername);
		
		WebElement passwordFieldEle = driver.findElement(By.xpath("//input[@id='password']"));
		String validPassword = appCred().get("validUser").split("#")[1];
		System.out.println(validPassword);
		passwordFieldEle.sendKeys(validPassword);
		
		WebElement loginButtonEle = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButtonEle.click();
		
		WebElement homepageLogoTextEle = driver.findElement(By.xpath("//div[text()='Swag Labs']"));
		
		Assert.assertEquals(true, homepageLogoTextEle.isDisplayed());
	}
	
	@Test
	public void inValidUser()
	{
		
		WebElement invalidUsernameFieldEle = driver.findElement(By.xpath("//input[@id='user-name']"));
		String invalidUsername = appCred().get("invalidUser").split("#")[0];
		System.out.println(invalidUsername);
		invalidUsernameFieldEle.sendKeys(invalidUsername);
		
		WebElement invalidpassowdFieldEle = driver.findElement(By.xpath("//input[@id='password']"));
		String invalidPassword = appCred().get("invalidUser").split("#")[1];
		System.out.println(invalidPassword);
		invalidpassowdFieldEle.sendKeys(invalidPassword);
		
		
		WebElement loginButtonEle = driver.findElement(By.xpath("//input[@id='login-button']"));
		loginButtonEle.click();
		
		WebElement errorMsgEle = driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']"));

		Assert.assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMsgEle.getText());
		
	}
	
	/**
	 * This method is for storing app credentials
	 * for valid and invalid user
	 * @return
	 * a hashmap with valid and invalid user cred
	 */
	public static HashMap<String, String> appCred()
	{
		HashMap<String,String> credentials = new HashMap<String,String>();
		credentials.put("validUser", "standard_user#secret_sauce");
		credentials.put("invalidUser", "locked_out_user#secret_sauce");
		return credentials;
	}
	
	
	
	
	
	
	

}
