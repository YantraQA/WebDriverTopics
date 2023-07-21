package _15_BrokenImagesAndLinks;

import java.awt.AWTException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksHandling {
	
	static WebDriver driver;
	String Url = "https://www.myntra.com/";
	
	@Before
	public void setup() throws AWTException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(Url);
	}

	// Quick note - 
	// Images are refered img tag
	// img src=http://www/test.com/img_1_logo.png
	@Test
	public void _1_TestForBrokenImages()
	{
		List<WebElement> linkListWithImgTag = driver.findElements(By.tagName("a"));
		System.out.println("Total a tag found with in URL -> " + Url + " is " + linkListWithImgTag.size());

		for (int i = 0; i < linkListWithImgTag.size(); i++) 
		{
			String imageSourceLink = linkListWithImgTag.get(i).getAttribute("href");

			try 
			{
				// Creating a URL
				URL url = new URL(imageSourceLink);
				// Creating a connection with URL
				URLConnection urlConnection = url.openConnection();
				// Setting up the connection protocol as HTTP or HTTPS
				// ex -> HttpsURLConnection httpURLConnection = (HttpsURLConnection) urlConnection;		
				HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
				// Setting up connection timeout
				httpURLConnection.setConnectTimeout(4000);
				// Connecting with the url with HTTP protocol
				httpURLConnection.connect();
				// Validating the response from the URL in the form of HTTP response code
				if (httpURLConnection.getResponseCode() == 200) {
					System.out.println("The Image Source Link " + imageSourceLink + " -> is " + httpURLConnection.getResponseCode());
				}
				else {
					System.err.println("The Image Source Link " + imageSourceLink + " -> is " + httpURLConnection.getResponseCode());
				}
				// disconnecting the connection with URL
				httpURLConnection.disconnect();
			} 
			catch (Exception e) 
			{
				System.out.println("Some issue with source link ->" + imageSourceLink);
				e.printStackTrace();
			}				
		}

	}

	@After
	public void tearDown()
	{
		driver.quit();
	}

}
