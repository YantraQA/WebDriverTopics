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

import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.LandingPage_Variables;

public class _1_ValidateColourOfElement {
	
	WebDriver driver;
	
	String url = "https://www.facebook.com/";
	final String fbLogInButtonColourValue = "#1877f2";
	
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
	
		System.out.println("The color for \"Login\" button is -> " + loginButtonElement.getCssValue("background-color"));
		
		String actualColourValForElement = loginButtonElement.getCssValue("background-color");
		System.out.println("After converting RGB color value for \"Login\" button to the HEX Value Output is : " + rgbToHexValue(actualColourValForElement));
		
		Assert.assertEquals("The colour for \"Login\" button is not matching with expected value.", fbLogInButtonColourValue, rgbToHexValue(actualColourValForElement));
		System.out.println("Test for Colour of Element is passed.");
	}
	
	/**
	 * This method converts the RGB value to its HEX code
	 * 
	 * @param rbgValue
	 * @return String HEX value
	 */
	public static String rgbToHexValue(String rbgValue)
	{
		return Color.fromString(rbgValue).asHex();
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}

}
