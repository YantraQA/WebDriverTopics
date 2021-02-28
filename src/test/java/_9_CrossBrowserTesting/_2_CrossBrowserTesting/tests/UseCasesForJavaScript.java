package _9_CrossBrowserTesting._2_CrossBrowserTesting.tests;

import java.util.ArrayList;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UseCasesForJavaScript {

	static WebDriver driver;
	
	@Before
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/index.php");
	}
	
	
	@Test
	public void _0_Test() throws InterruptedException
	{
		driver.get("https://www.irctc.co.in/nget/train-search");
		Thread.sleep(3000);	
		WebElement logInButton = driver.findElement(By.xpath("//a[text()=' LOGIN ']"));
		//logInButton.click();
		clickElementByJS(logInButton);
		sendKeysUsingJSWithId("userId", "textUser");
		Thread.sleep(3000);	
		System.out.println(driver.getTitle());		
	}

	
	@Test
	public void _1_Test() throws InterruptedException
	{
		Thread.sleep(3000);	
		WebElement singInButton = driver.findElement(By.xpath("//a[@title='Log in to your customer account']"));
		clickElementByJS(singInButton);
		Thread.sleep(3000);	
		System.out.println(driver.getTitle());		
	}
	
	@Test
	public void _2_Test() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement singInButton = driver.findElement(By.xpath("//a[@title='Specials']"));
		singInButton.click();
		Thread.sleep(3000);	
		System.out.println(driver.getTitle());			
	}
	
	@Test
	public void _3_Test() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement singInButton = driver.findElement(By.xpath("//a[@title='Specials']"));
		scrollPageDown();
		drawBorder(singInButton);
		clickElementByJS(singInButton);
		Thread.sleep(3000);	
		System.out.println(driver.getTitle());			
	}
	
	@Test
	public void _4_Test() throws InterruptedException
	{
		Thread.sleep(3000);
		openNewWindowTab("https://www.google.co.in");
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
	}
	
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	public static void clickElementByJS(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public void scrollPageDown() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public void drawBorder(WebElement element) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public void sendKeysUsingJSWithId(String id, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
	
	public void openNewWindowTab(String newURL)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open();");
		ArrayList<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windowHandles.get(1));
		driver.get(newURL);
	}
}
