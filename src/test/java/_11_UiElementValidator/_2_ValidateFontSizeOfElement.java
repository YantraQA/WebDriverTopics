package _11_UiElementValidator;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class _2_ValidateFontSizeOfElement {
	
WebDriver driver;
	
	String url = "https://www.facebook.com/";
	final String fbLogInButtonFontSizeValue = "20px";
	
	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
		

	}
	
	@Test
	public void testColourOfElement()
	{
		WebElement loginButtonElement = driver.findElement(By.xpath("//button[@name='login']"));
	
		System.out.println("The font size for \"Login\" button is -> " + loginButtonElement.getCssValue("font-size"));
		
		Assert.assertEquals("The colour for \"Login\" button is not matching with expected value.", fbLogInButtonFontSizeValue, loginButtonElement.getCssValue("font-size"));
		System.out.println("Test for Font Size of Element is passed.");
	}
	
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
