package _5_AltertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _8_FileUpload {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
	}

	@Test
	public void dropDown() throws InterruptedException 
	{
		// Note - Type=file or Name=Upfile should be available for this in the DOM
		
		WebElement chooseFileButton = driver.findElement(By.xpath("//input[@type='file']"));
		chooseFileButton.sendKeys("C:\\testDemoFile.txt");

		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);

		WebElement pressButton = driver.findElement(By.xpath("//input[@type='submit']"));
		pressButton.click();
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}

}
