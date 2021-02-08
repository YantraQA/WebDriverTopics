package _3_Xpaths;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_DynamicRelativeXpath_1 {

	WebDriver driver;
	String TextToBeClicked = "Pepe T Shirts";

	@Before
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com/");
	}


	@Test
	public void searchboxTest() throws InterruptedException
	{
		// Creating webelement for search box
		WebElement searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
		searchBox.sendKeys("pepe");
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(5000);
		
		// Finding the list of all options after the search
		List <WebElement> searchList = driver.findElements(By.xpath("//ul[@class='desktop-group']//li[@class='desktop-suggestion null']"));		
		
		// Printing the searched products count
		System.out.println("The search result count is :> " + searchList.size());
		
		
		// Iterating though each options till it find the desired product name
		for (int i = 0; i < searchList.size(); i++) {
		
			// Checking each option is matched with the desired product option to be clicked
			if(searchList.get(i).getText().equals(TextToBeClicked))
			{
				// Clicking on the desired product 
				searchList.get(i).click();
				
				// Finding the prices listed below all the products displayed
				// Can use this one also -> //ul[@class='results-base']//li//span[@class='product-discountedPrice']
				List<WebElement> allPricesOfMensJackets = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
				
				
				System.out.println("All Jackets prices are as below -> ");
				
				int x = 0;
				
				// Iterating though all the prices of products displayed
				for (int j = 0; j < allPricesOfMensJackets.size(); j++) {
				
					// Printing the price of all products dipsplayed one by one through itration
					System.out.println(allPricesOfMensJackets.get(j).getText());
					
					// adding up all the values one by one through itration in a single variable by conerting and fetching only the value through price string
					x = x + Integer.valueOf(allPricesOfMensJackets.get(j).getText().substring(5));
				}
				
				// Printing the total of all products displayed on the screen
				System.out.println("Total for all " +  TextToBeClicked + " is +-> " + x);
			}
		}
		
		// To Halt the execution for sometime (demonstration purposes)
		Thread.sleep(5000);

	}

	@After
	public void teardown()
	{
		driver.quit();
	}
	
}
