package _6_DesiredCapabilitiesSynchronisationToolTip;

import java.util.List;
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

public class _4_Synchronisation_1 {
	
	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setUp()
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		wait = new WebDriverWait(driver, 15);
	}
	
	@Test
	public void dropDown() throws InterruptedException
	{
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("nokia");
		
		List<WebElement> searchList = driver.findElements(By.xpath("//div[@id='suggestions-template']/div[@id='suggestions']/div[@data-alias='aps']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(searchList));
		
		for (int i = 0; i < searchList.size(); i++) {
			
			System.out.println(searchList.get(i).getText());
			
		}
		
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}


}
