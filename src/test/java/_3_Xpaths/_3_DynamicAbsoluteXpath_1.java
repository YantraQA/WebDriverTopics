package _3_Xpaths;

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

public class _3_DynamicAbsoluteXpath_1 {

	WebDriver driver;
	String TextToBeClicked = "Pepe Jeans Jackets Men";

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}


	@Test
	public void searchboxTest() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchBox.sendKeys("pepe");
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		
		List <WebElement> searchList = driver.findElements(By.xpath("//ul[@class='desktop-group']//li[@class='desktop-suggestion null']"));
		System.out.println("The search result count is : "+searchList.size());
		for (int i = 0; i < searchList.size(); i++) {
		
			//System.out.println(searchList.get(i).getText());
			if(searchList.get(i).getText().equals(TextToBeClicked))
			{
				searchList.get(i).click();
				break;
			}
		}
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(5000);

	}

	@After
	public void teardown()
	{
		driver.quit();
	}
	
}
