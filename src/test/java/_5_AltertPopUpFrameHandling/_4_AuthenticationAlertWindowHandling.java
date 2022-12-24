package _5_AltertPopUpFrameHandling;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_AuthenticationAlertWindowHandling {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
	
	@Test
	public void dropDown1() throws InterruptedException 
	{

		String username = "admin";
		String password = "admin";
		String URL = "http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/digest_auth";
		driver.get(URL);
		
		Assert.assertEquals(true, driver.findElement(By.xpath("//p[contains(text(),'Congratulations!')]")).getText().contains("Congratulations!"));
		
		//or
		
                // WebElement authSuccessEle = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"));
		
 		//System.out.println("After auth success the text is -> " + authSuccessEle.getText());
		
		//Assert.assertEquals("Congratulations! You must have the proper credentials.", authSuccessEle.getText());
		
		//Assert.assertEquals(true, authSuccessEle.isDisplayed());
		//Assert.assertEquals(true, authSuccessEle.getText().contains("Congratulations!"));

	}

	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}

}
