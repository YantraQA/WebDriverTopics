package _12_CalendarScenario;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_DatePicker {

	static WebDriver driver;

	String url = "http://demo.automationtesting.in/Datepicker.html";
	String DateValue = "02/28/2022";

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
	public void _1_pickADateByUsingJavaScript() throws InterruptedException
	{
		selectValueByIDJavaScript(driver, "datepicker1", DateValue);
		Thread.sleep(3000);
	}
	
	@Test
	public void _2_pickADateByUsingJavaScript() throws InterruptedException
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('datepicker1').value='02/28/2022'");
		Thread.sleep(3000);
	}

	public static void selectValueByIDJavaScript(WebDriver driver, String elementId, String valueTobeEntered) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementById('"+elementId+"').value='"+valueTobeEntered+"'");
	}
	
	public static void selectValueByCSSJavaScript(WebDriver driver, String elementId, String valueTobeEntered) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.querySelector('"+elementId+"').value='"+valueTobeEntered+"'");
	}

	public static void selectValueByJavaScript(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+value+"');", element);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
