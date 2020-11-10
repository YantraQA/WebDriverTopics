package _3_Xpaths;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _4_ListOfLinksFromWebpage {
	
	
	@Test
	public void findLinks() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		
		driver.get("https://www.google.co.in");
		
		List<WebElement> linksOnPage = driver.findElements(By.tagName("a"));
	
		System.out.println("Total no of links count on the page is " + linksOnPage.size());
		
		// Printing the all link text
//		for (int i = 0; i < linksOnPage.size(); i++) 
//		{
//			System.out.println((i+1) + ". " + linksOnPage.get(i).getText());
//		}
		
		// Print the all link text without blank value
		for (int i = 0; i < linksOnPage.size(); i++) 
		{
			if (linksOnPage.get(i).getText().isEmpty()) 
			{
				
			}
			else {
				System.out.println((i+1) + ". " + linksOnPage.get(i).getText());
			}
		}
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
