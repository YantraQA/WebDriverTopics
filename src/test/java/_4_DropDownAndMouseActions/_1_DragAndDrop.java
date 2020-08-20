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

public class _1_DragAndDrop {
	
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable");
	}
	
	@Test
	public void dropDown() throws InterruptedException
	{
		//WebElement element1 = driver.findElement(By.id("draggable"));
		WebElement element1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		//WebElement dropArea = driver.findElement(By.id("droppable"));
		WebElement dropArea = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
		Actions act = new Actions(driver);
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		
		act.clickAndHold(element1).moveToElement(dropArea).build().perform();
		//act.dragAndDrop(element1, dropArea).build().perform();
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}

}
