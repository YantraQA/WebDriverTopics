package _7_ScreenShotCaptureNJavaScriptUtils._2_JavaScriptUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import _7_ScreenShotCaptureNJavaScriptUtils._2_JavaScriptUtil.JavaScriptUtil;
import net.bytebuddy.utility.JavaType;

public class _1_JavScriptDemo {
	
	WebDriver driver;
	WebDriverWait wait;
	JavaScriptUtil javaScriptUtil;
	String URL = "https://www.google.com";
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		wait = new WebDriverWait(driver, 15);
		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	@Test
	public void tc_01()
	{
		
		//System.out.println(System.getProperty("user.dir"));
		WebElement searchBox = driver.findElement(By.name("q"));
		
		// Drawing border around the element
		javaScriptUtil.drawBorder(searchBox);
		
		// flashing the element 
		javaScriptUtil.flash(searchBox);
		searchBox.sendKeys("Selenium");
		
		WebElement searchButton = driver.findElement(By.name("btnK"));
		// clicking the element by using javascript
		javaScriptUtil.clickElementByJS(searchButton);
		
		// Scrolling down the page
		javaScriptUtil.scrollPageDown();
		
		// Fetching the page title by javascript
		String pageTitle = javaScriptUtil.getTitleByJS();
		System.out.println("Current Page Title is : " + pageTitle);
		
		// Generating alert by javascript
		javaScriptUtil.generateAlert("Current Page Title is : " + pageTitle);
		
		// Handling alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		wait.until(ExpectedConditions.titleContains("Selenium"));
		
		WebElement javatpointLink = driver.findElement(By.xpath("//h3[contains(text(),'Selenium Tutorial - javatpoint')]"));
		
		wait.until(ExpectedConditions.elementToBeClickable(javatpointLink));
		
		javatpointLink.click();
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
