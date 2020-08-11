package _1_BrowserBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class _3_OperaInvocation {

	public static void main(String[] args) {

		// Set the path of browser driver 
		System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/operadriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new OperaDriver();

		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies

		// entering url to open
		driver.get("https://www.amazon.in/");
		
		// Fetching the actual page title
		String pageTitle = driver.getTitle();
		
		String expectedTitleIs = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

		// Validation
		if(pageTitle.equals(expectedTitleIs))
		{
			System.out.println("Page title is correct");
		}
		else {
			System.out.println("Page Title is incorrect");
		}

		// closing the current opened browser window
		driver.quit();
	}


}
