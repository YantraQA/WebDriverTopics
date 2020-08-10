package _1_BrowserBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _2_FirefoxInvocation {

	public static void main(String[] args) {

		// Set the path of browser driver 
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies

		// entering url to open
		driver.get("https://www.google.co.in");
		String pageTitle = driver.getTitle();

		// Validation
		if(pageTitle.equals("Google"))
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
