package _5_AltertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _1_AlertHandling {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]"));
		alertButton.click();
		
		
		Alert alert = driver.switchTo().alert();
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(2000);
		
		// Fetching the alert text
		System.out.println("Text of alert is : " + alert.getText());
		
		alert.accept();
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}
	
}
