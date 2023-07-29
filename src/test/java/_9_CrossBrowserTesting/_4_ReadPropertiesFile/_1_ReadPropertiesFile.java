package Session_12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _1_ReadPropertiesFile {
	
	WebDriver driver;
	public Properties prop;
	
	@Test
	public void fileUpload_1() throws InterruptedException
	{
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/Session_12/config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("config.properties file not found please provide a correct path");
			e.printStackTrace();
		} 
		catch (IOException e) {
			System.out.println("IOException occured while loading the config.properties file");
			e.printStackTrace();
		}
				
		if(prop.getProperty("headless").equals("yes"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarang\\eclipse-workspace\\Batch - 21\\SeleniumWebDriverB21\\chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.setBinary("C:\\Users\\Sarang\\eclipse-workspace\\Batch - 21\\chrome-win64\\chrome-win64\\chrome.exe");
			opt.addArguments("headless");
			driver = new ChromeDriver(opt);
		}
		else if(prop.getProperty("browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sarang\\eclipse-workspace\\Batch - 21\\SeleniumWebDriverB21\\chromedriver.exe");
			ChromeOptions opt = new ChromeOptions();
			opt.setBinary("C:\\Users\\Sarang\\eclipse-workspace\\Batch - 21\\chrome-win64\\chrome-win64\\chrome.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equals("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver = new OperaDriver();
		}
		
		if(prop.getProperty("maximize").equals("yes"))
		{
			driver.manage().window().maximize();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		System.out.println("Current Page Title is :- " + driver.getTitle());
		
		driver.quit();

	}

}
