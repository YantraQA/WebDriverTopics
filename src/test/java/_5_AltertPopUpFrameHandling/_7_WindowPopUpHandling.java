package _5_AltertPopUpFrameHandling;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _7_WindowPopUpHandling {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://popuptest.com/goodpopups.html");
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		WebElement link1 = driver.findElement(By.linkText("Good PopUp #1"));
		link1.click();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWindowId = it.next();
		String childWindowId = it.next();

		driver.switchTo().window(childWindowId);

		System.out.println("Child window title is - " + driver.getTitle());

		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		System.out.println("Parent window title is - " + driver.getTitle());

	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}

}
