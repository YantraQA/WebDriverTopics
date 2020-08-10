package _2_Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _2_PageElementsInteractByName {

	public static void main(String[] args) throws InterruptedException {

		// Set the path of browser driver 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Invoking the browser with given URL
		driver.get("http://www.google.co.in");
		
		// Finding the WebElement of SearchBox
		WebElement searchBox = driver.findElement(By.name("q"));
		
		// Entering text into the search box
		searchBox.sendKeys("Selenium");
		
		// Waiting for the Google Search button to appear after entering the search keyword
		Thread.sleep(4000);
		
		// Finding the WebElement of Google Search button
		WebElement searchButton = driver.findElement(By.name("btnK"));
		
		// Clicking on Google Search button
		searchButton.click();
		
		// Waiting for next page to load 
		//Thread.sleep(5000);
		
		// Fetching the page title & printing it
		System.out.println("The Page Title is : " + driver.getTitle());

		// Closing The browser
		driver.quit();

	}

}
