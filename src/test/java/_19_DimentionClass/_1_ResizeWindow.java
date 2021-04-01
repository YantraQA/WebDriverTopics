package _19_DimentionClass;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_ResizeWindow {
	
	static WebDriver driver;

	String url = "http://automationpractice.com";

	@Before
	public void setup()
	{
		//To resize the browser window to particular dimensions, we use ‘Dimension’ class to resize the browser window
		//Create object of Dimensions class
		Dimension d = new Dimension(480,620);
		
		driver = new ChromeDriver();
		//Resize the current window to the given dimension
		driver.manage().window().setSize(d);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	@Test
	public void windowResizeCode() throws InterruptedException
	{
		System.out.println("Currnet Page Title After resizing the window is : " + driver.getTitle());
		
		// For demonstation purpose only,
		// to see the window size is resized to the specified resolution given as parameter to constructor of Dimension Class
		// in @Before anotation setup() method
		Thread.sleep(5000);

	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
