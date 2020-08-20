package _4_DropDownAndMouseActions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class _4_DoubleClick {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		WebElement righClickMeButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));

		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.doubleClick(righClickMeButton).build().perform();
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}

}
