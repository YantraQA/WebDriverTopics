package _2_Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_PageElementsInteractById {

	public static void main(String[] args) {

		// Set the path of browser driver 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // set a maximum timeout for searching out the WebElements before throwing an exception 

		// Invoking the browser with given URL
		driver.get("http://demo.automationtesting.in/Index.html");
		
		System.out.println("Landing page title " + driver.getTitle());
		
		// Finding the WebElement of SearchBox for username field
		WebElement userNameField = driver.findElement(By.id("email"));
		
		// Entering Text into User Name field
		userNameField.sendKeys("test@gmail.com");

		// Clicking on proceed button
		WebElement proceedButton = driver.findElement(By.id("enterimg"));
		proceedButton.click();
		
		// Fetching the next page title
		String nextPageTitle = driver.getTitle();
		
		// Printing the next page title
		System.out.println(nextPageTitle);

		// Closing the browser
		driver.quit();

	}

}
