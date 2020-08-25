 package _6_DesiredCapabilitiesSynchronisationToolTip;

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

public class _1_ToolTipHandling {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/tool-tips/");
	}

	@Test
	public void dropDown() throws InterruptedException
	{
		
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement hoverButton = driver.findElement(By.id("toolTipButton"));

		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);

		Actions act = new Actions(driver);
		act.moveToElement(hoverButton).build().perform();

		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);

		WebElement suggestionTextElement = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
		String suggestionText = suggestionTextElement.getText();
		System.out.println("Suggestion Box text is : " + suggestionText);
		
		Assert.assertEquals("You hovered over the Button", suggestionText);

		
	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}

}
