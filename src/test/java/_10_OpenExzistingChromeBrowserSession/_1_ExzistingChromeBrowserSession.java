package _10_OpenExzistingChromeBrowserSession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _1_ExzistingChromeBrowserSession 
{
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress", "localhost:9922");
		
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Base Page Title Is:" + driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
		
		System.out.println("Next Page Title Is:" + driver.getTitle());
		
		driver.findElement(By.xpath("//span[text()='Selenium WebDriver']//ancestor::a")).click();
		System.out.println("Link Page Title Is:" + driver.getTitle());
		
		
	}
	
	// Comments -
	// 1. Set the Chrome.exe path into system variable path
	// 2. Execute the below command before start executing the script
	// 3. chrome.exe --remote-debugging-port=9922 chrome.exe --user-data-dir=<some directory>
	// 4. Note - Can select any port number in above command (4 digits)
	// 5. Ex -> chrome.exe --remote-debugging-port=9922 chrome.exe --user-data-dir=C:\Users\Sarang\eclipse-workspace\WebDriverTopics\src\test\java\_10_OpenExzistingChromeBrowserSession\ChromeSessionPath
}
