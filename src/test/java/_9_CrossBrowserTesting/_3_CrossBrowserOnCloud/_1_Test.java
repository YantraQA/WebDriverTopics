package _9_CrossBrowserTesting._3_CrossBrowserOnCloud;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class _1_Test {

	
	// Links
	// 1. https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/
	// 2. public static final String USERNAME = "YOUR_USERNAME";
	//	public static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
	//	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	public static final String USERNAME = "tompeter_6699";
	public static final String ACCESS_KEY = "ebe9983b-071a-4679-bcda-7f30bcb1e6f2";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "macOS 10.14");
		
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		System.out.println(driver.getTitle());
		
		WebElement alertButton = driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]"));
		alertButton.click();
		
		
		Alert alert = driver.switchTo().alert();
		
		Thread.sleep(2000);
		
		System.out.println("Text of alert is : " + alert.getText());
		
		Assert.assertEquals("Alert text is not matching","I am an alert box!", alert.getText());
		
		alert.accept();
		
		Thread.sleep(10000);
		
		driver.quit();

	}

}
