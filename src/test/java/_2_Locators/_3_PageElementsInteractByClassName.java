package _2_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_PageElementsInteractByClassName {

	public static void main(String[] args) throws InterruptedException {

		// Set the path of browser driver 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Invoking the browser with given URL
		driver.get("http://zero.webappsecurity.com/");

		// Finding the WebElement for SignIn button
		WebElement signInButton = driver.findElement(By.className("signin"));

		// Clicking on the Sign In box
		signInButton.click();

		// Waiting for login page to load
		Thread.sleep(4000);
		
		System.out.println("The page title after clicking on Sign In Button is : " + driver.getTitle());

		// Closing The browser
		driver.quit();

	}

}
