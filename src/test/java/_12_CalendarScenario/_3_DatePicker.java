package _12_CalendarScenario;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _3_DatePicker 
{

	public static WebDriver driver;
	public static WebDriverWait wait;
	public String url = "http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html";

	public static String requiredDateNumber = "31";
	public static String requiredMonth = "March";
	public static String requiredYearNumber = "2019";

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);

		wait = new WebDriverWait(driver, 20);
	}

	@Test
	public void _1_pickADateRoughCode() throws InterruptedException
	{

		WebElement datePickerBoxElement = driver.findElement(By.xpath("//input[@id='datepicker']"));
		wait.until(ExpectedConditions.elementToBeClickable(datePickerBoxElement));

		datePickerBoxElement.click();

		WebElement currentMonthYearElement = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
		String currentMonthYear = currentMonthYearElement.getText();

		System.out.println("Current Month & Year showing up by date picker is : " + currentMonthYear); // March 2021
		String monthValue = currentMonthYear.split(" ")[0].trim();
		String yearValue = currentMonthYear.split(" ")[1].trim();

		while (!(monthValue.equals(requiredMonth) && yearValue.equals(requiredYearNumber))) 
		{
			WebElement nextButtonElement = driver.findElement(By.xpath("//span[text()='Next']"));
			nextButtonElement.click();

			currentMonthYearElement = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
			currentMonthYear = currentMonthYearElement.getText();
			monthValue = currentMonthYear.split(" ")[0].trim();
			yearValue = currentMonthYear.split(" ")[1].trim();


		}

		System.out.println("Current Month & Year showing up by date picker is : " + currentMonthYear);

		WebElement requiredDateNumberElement = driver.findElement(By.xpath("//a[text()='"+requiredDateNumber+"']"));
		requiredDateNumberElement.click();
	}

	@Test
	public void _1_pickADateFinalCode() throws InterruptedException
	{

		try {
			selectDate(requiredDateNumber, requiredMonth, requiredYearNumber, "previous");
		} catch (Exception e) {
			System.out.println("Invalid Date Exception Occured");
			e.printStackTrace();
		}
	}

	/**
	 * This method is to select a date from date picker
	 * @param requiredDate
	 * @param requiredMonth
	 * @param requiredYear
	 * @throws Exception InvalidDateException
	 */
	public void selectDate(String requiredDate, String requiredMonth, String requiredYear, String previousOrNextDate) throws Exception
	{
		if (requiredMonth.equalsIgnoreCase("February") && (Integer.parseInt(requiredDate)>29)) 
		{
			throw new Exception("InvalidDateException");
		}

		else if (Integer.parseInt(requiredDate)>31)
		{
			throw new Exception("InvalidDateException");
		}

		else 
		{
			WebElement datePickerBoxElement = driver.findElement(By.xpath("//input[@id='datepicker']"));
			wait.until(ExpectedConditions.elementToBeClickable(datePickerBoxElement));

			datePickerBoxElement.click();

			WebElement currentMonthYearElement = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
			String currentMonthYear = currentMonthYearElement.getText();
			String monthValue = currentMonthYear.split(" ")[0].trim();
			String yearValue = currentMonthYear.split(" ")[1].trim();

			while (!(monthValue.equals(requiredMonth) && yearValue.equals(requiredYear))) 
			{
				if (previousOrNextDate.equalsIgnoreCase("previous")) 
				{
					WebElement previousButtonElement = driver.findElement(By.xpath("//span[text()='Prev']"));
					previousButtonElement.click();
				}
				else
				{
					WebElement nextButtonElement = driver.findElement(By.xpath("//span[text()='Next']"));
					nextButtonElement.click();		
				}

				currentMonthYearElement = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
				currentMonthYear = currentMonthYearElement.getText();
				monthValue = currentMonthYear.split(" ")[0].trim();
				yearValue = currentMonthYear.split(" ")[1].trim();			
			}

			int dateNumber = Integer.parseInt(requiredDate);
			WebElement requiredDateNumberElement = driver.findElement(By.xpath("//a[text()='"+dateNumber+"']"));
			requiredDateNumberElement.click();
		}

	}

	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
