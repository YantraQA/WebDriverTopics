package _14_WebTableHandingAndXpathAxes;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_WebTableHandingSorting {

	WebDriver driver;

	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/howto/howto_js_sort_table.asp");
	}

	@Test
	public void _2_WebTableHandingExample1()
	{
		List<WebElement> defaultListOfCountries = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[1]"));

		String[] array_1 = new String[defaultListOfCountries.size()];

		for (int i = 0; i < array_1.length; i++) {
			array_1[i] =  defaultListOfCountries.get(i).getText();
		}

		System.out.println("------------------------------- Default values ------------------------------------");
		printArray(array_1);
		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("------------------------ Sorted Values By Sort Function ---------------------------");
		Arrays.sort(array_1);
		printArray(array_1);
		System.out.println("-----------------------------------------------------------------------------------");

		driver.findElement(By.xpath("//button[text()='Sort']")).click();

		defaultListOfCountries = driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[1]"));
		String[] array_2 = new String[defaultListOfCountries.size()];

		for (int i = 0; i < array_2.length; i++) {
			array_2[i] =  defaultListOfCountries.get(i).getText();
		}
		
		System.out.println("------------ Sorted values form after clicking on sort button on page --------------");
		printArray(array_2);
		System.out.println("------------------------------------------------------------------------------------");
		
		Assert.assertEquals(array_1, array_2);
	}

	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

	/**
	 * This method will print the values form
	 * given array
	 * @param array
	 */
	public static void printArray(String[] array)
	{
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

}
