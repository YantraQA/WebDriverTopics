package _2_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _6_PageElementsInteractByCssSelector {

	public static void main(String[] args) throws InterruptedException {

		// Set the path of browser driver 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies

		// Invoking the browser with given URL
		driver.get("https://www.google.co.in/");

		// Finding the WebElement for search box by css selector with class name attribute having value "gLFyf"
		WebElement searchBox = driver.findElement(By.cssSelector("input.gLFyf"));
		
		// Entering text into the search box
		searchBox.sendKeys("Automation Testing");

		// Waiting for the Google Search button to appear after entering the search keyword
		Thread.sleep(4000);
		
		// Finding the WebElement of Google Search button by css selector with name attribute having value "btnK"
		WebElement searchButton = driver.findElement(By.cssSelector("input[name=btnK]"));
		
		// Clicking on Google Search button
		searchButton.click();
		
		// Waiting for next page to load 
		//Thread.sleep(5000);
		
		// Fetching the page title & printing it
		System.out.println("The Page Title is : " + driver.getTitle());

		// Closing the browser
		driver.quit();

	}

}
