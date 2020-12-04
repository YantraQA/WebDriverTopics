package _6_DesiredCapabilitiesSynchronisationToolTip;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _4_Synchronisation_2 {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions act;

	@Before
	public void setUp()
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		
		wait = new WebDriverWait(driver, 15);
		
		act = new Actions(driver);
	}
	
	@Test
	public void dropDown() throws InterruptedException
	{
		
		WebElement helloSignInButton = driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]"));
		act.moveToElement(helloSignInButton).perform();
		
		List<WebElement> yourAccountOptions = driver.findElements(By.xpath("//div[@id='nav-al-your-account']/a/span"));
		wait.until(ExpectedConditions.visibilityOfAllElements(yourAccountOptions));
		System.out.println("After mouse hover on Hello, \"Sign In\" Your Account List contains total of Options in number as - " + helloSignInButton.getSize());
		System.out.println("And the List options available as below - ");
		for (int i = 0; i < yourAccountOptions.size(); i++) {
			System.out.println((i+1) + " " + yourAccountOptions.get(i).getText());
		}	
	}
	
	@After
	public void teardown() throws InterruptedException
	{
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(3000);
		driver.quit();
	}


}
