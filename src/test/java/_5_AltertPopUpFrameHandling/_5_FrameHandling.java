package _5_AltertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _5_FrameHandling {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Frames.html");
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		WebElement multiFrameButton = driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']"));
		multiFrameButton.click();
		
		// Switching to frame 1
		WebElement frame1 = driver.findElement(By.xpath("//div[@id='Multiple']//iframe"));
		driver.switchTo().frame(frame1);
		
		// switching to frame inside frame 1
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='row']/iframe")));
		
		WebElement textBoxInFrame = driver.findElement(By.xpath("//input[@type='text']"));
		textBoxInFrame.sendKeys("Test test test");
		
		// switching back to main window
		
		// either
		driver.switchTo().defaultContent();
		
		// Or
//		driver.switchTo().parentFrame(); // switch back to frame 1
//		driver.switchTo().parentFrame(); // switch back from frame 1 to main window
		
		WebElement pageCenterText = driver.findElement(By.xpath("//h1[text()='Automation Demo Site ']"));
		System.out.println(pageCenterText.getText());
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}
	
}
