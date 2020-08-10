package _1_BrowserBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_ChromeInvocation {

	public static void main(String[] args) {
		
		
		// Set the path of browser driver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
		
		
		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies
				
		// entering url to open
		driver.get("https://demo.cs-cart.com/");
		
		// fetching page title
		String pageTitle = driver.getTitle();
		System.out.println("Current Page titke is : " + pageTitle);
		
		// fetching page url after the page is opened in browser
		String pageUrl = driver.getCurrentUrl();
		System.out.println("Current Page Url is : "+ pageUrl);
		
		
		//System.out.println("Current Page Source is : "+ driver.getPageSource());

		
		// Validation
		if(pageTitle.equals("Shopping Cart Software & Ecommerce Software Solutions by CS-Cart"))
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
