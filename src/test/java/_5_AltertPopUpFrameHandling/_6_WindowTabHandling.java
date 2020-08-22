package _5_AltertPopUpFrameHandling;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _6_WindowTabHandling {
	
	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Windows.html");
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		
		WebElement clickButtonForTab = driver.findElement(By.xpath("//div[@id='Seperate']/button[contains(text(),'click')]"));
		clickButtonForTab.click();
		
		System.out.println("Currect Window title is : " + driver.getTitle());

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWindowId = it.next();
		String childWindowID1 = it.next();
	
		System.out.println("Parent window id is - " + parentWindowId);
		
		driver.switchTo().window(childWindowID1);

		System.out.println("Child1 window title is - " + driver.getTitle());
		System.out.println("Child1 window id is - " + childWindowID1);
		driver.close();
		
		driver.switchTo().window(parentWindowId);

		System.out.println("Parent window title is - " + driver.getTitle());
		System.out.println("Parent window id is - " + parentWindowId);

		
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}
	
}
