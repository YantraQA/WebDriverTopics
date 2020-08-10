package _2_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _7_PageElementsInteractByXpath {

	public static void main(String[] args) throws InterruptedException {

		// Set the path of browser driver 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		// Topcasting/Upcasting - Object of chromedriver class with webdriver interface
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); // maximize browser window 
		driver.manage().deleteAllCookies(); // delete all cookies
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Invoking the browser with given URL
		driver.get("http://demo.automationtesting.in/Register.html");

		// Finding the WebElement of First Name field by using xpath
		WebElement firstNameTextBox = driver.findElement(By.xpath("//input[@placeholder='First Name']"));

		// Entering text into the search box
		firstNameTextBox.sendKeys("Tom");

		// Fetching the page title & printing it
		System.out.println("The Page Title is : " + driver.getTitle());

	}

}
