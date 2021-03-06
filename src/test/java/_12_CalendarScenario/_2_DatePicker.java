package _12_CalendarScenario;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class _2_DatePicker {

	static WebDriver driver;

	String url = "http://demo.automationtesting.in/Datepicker.html";
	String monthToBeSelected = "April";
	String yearToBeSelected = "2022";
	String dateToBeSelected = "28";

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
		Thread.sleep(5000);

		WebElement datePickerElement = driver.findElement(By.id("datepicker2"));
		datePickerElement.click();
		Thread.sleep(5000);
		WebElement monthDropDownElement = driver.findElement(By.xpath("//select[@title='Change the month']"));
		selectValueByVisibleText(monthDropDownElement, monthToBeSelected);
		Thread.sleep(5000);
		WebElement yearDropDownElement = driver.findElement(By.xpath("//select[@title='Change the year']"));
		selectValueByVisibleText(yearDropDownElement, yearToBeSelected);
		Thread.sleep(5000);
		WebElement dateNumberElement = driver.findElement(By.xpath("//table/tbody/tr/td/a[text()='"+dateToBeSelected+"']"));
		dateNumberElement.click();
		Thread.sleep(5000);
	}

	public static void selectValueByVisibleText(WebElement element, String valueToBeSelected)
	{
		Select select = new Select(element);
		select.selectByVisibleText(valueToBeSelected);
	}


	@After
	public void tearDown()
	{
		driver.quit();
	}

}
