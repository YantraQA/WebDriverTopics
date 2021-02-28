package _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;

public class Utils {
	
	
	// Class variables
	public WebDriver driver;
	public Properties prop;
	
	/**
	 * @author Sarang
	 * This method is for properties file initialization
	 * @return prop
	 */
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/_9_CrossBrowserTesting/_2_CrossBrowserTesting/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Config.properties file not found please give correct path");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException occured while loading the config.properties file");
			e.printStackTrace();
		}	
		return prop;
	}
	
	/**
	 * @author Sarang
	 * This method is for WebDriver initialization
	 * with different browser configurations
	 * @return
	 */
	public WebDriver init_driver(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		
		System.out.println("Running on ----> " + browserName + " browser" + ", " + System.getProperty("os.name")
		+ " , " + System.getProperty("os.arch") + " , " +  System.getProperty("os.version") + ", Java Version: "
		+ System.getProperty("java.version"));

		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
			
			if(prop.getProperty("headless").equalsIgnoreCase("yes"))
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("headless");
				driver = new ChromeDriver(options);
			}
			else 
			{
				driver = new ChromeDriver();
			}
		}
		
		else if(browserName.equalsIgnoreCase("firefox"))
		{	
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver.exe");
			
			if(prop.getProperty("headless").equalsIgnoreCase("yes"))
			{
				FirefoxOptions fb = new FirefoxOptions();
				fb.addArguments("--headless");
				driver = new FirefoxDriver(fb);
			}
			else 
			{
				driver = new FirefoxDriver();
			}		
		}
		
		else if(browserName.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver", System.getProperty("user.dir") + "/operadriver.exe");
			driver = new OperaDriver();
		}
		
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		else 
		{
			System.out.println(browserName + " is not found, please pass browser name as chrome, firefox, opera or edge");
		}
		
		if(prop.getProperty("maximize").equalsIgnoreCase("yes")) 
		{
			driver.manage().window().maximize();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("ImplicitWait")), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("PageLoadTimeout")), TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
}
