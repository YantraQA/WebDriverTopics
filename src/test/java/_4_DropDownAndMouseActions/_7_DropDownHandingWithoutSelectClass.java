package _4_DropDownAndMouseActions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _7_DropDownHandingWithoutSelectClass {
	
	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
	}

	@Test
	public void dropDownHandlingWithoutSelectClass() throws InterruptedException
	{
		
		List<WebElement> yearList = driver.findElements(By.xpath("//select[@id='yearbox']/option"));
		
		System.out.println("The All options from year list dropdown are : ");
		for (int i = 0; i < yearList.size(); i++) {
			
			System.out.println(yearList.get(i).getText());
			if (yearList.get(i).getText().equals("1954")) {
				
				yearList.get(i).click();
				
			}
			
		}
		
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)s
		Thread.sleep(3000);
		driver.quit();
	}

}
