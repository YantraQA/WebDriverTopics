package _14_WebTableHandingAndXpathAxes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _3_WebTableHandingFetchingValues {
	
	// For Test : _3_WebTableHandingExample1
	String dessertName = "Ice cream";
	
	// For Test : _3_WebTableHandingExample2
	String loanPaidToDatePercentage = "9.27%";
	
	static WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	@Ignore
	@Test
	public void _3_WebTableHandingExample1()
	{
		driver.get("https://letcode.in/table");
		// Note - 
		//tr[@class='ng-star-inserted']/td[text()='"+dessertName+"']//following-sibling::td -> without text function it will not print the values
		
		List<WebElement> desertNutitiveContentBreakupListElement = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']/td[text()='"+dessertName+"']//following-sibling::td[text()]"));
		
		System.out.println("The nutritional breakup for the desert \""+dessertName+"\" as below");
		for (int i = 0; i < desertNutitiveContentBreakupListElement.size(); i++) 
		{ 
			System.out.println((i+1) + ". " + desertNutitiveContentBreakupListElement.get(i).getText());
		}
		
	}
	
	
	@Test
	public void _3_WebTableHandingExample2()
	{
		driver.get("https://emicalculator.net/");
		
		WebElement loanPaidDueDateYear = driver.findElement(By.xpath("(//td[text()='"+loanPaidToDatePercentage+"']/parent::tr/td[text()])[1]"));
		
		System.out.println("Loan paid due date percentage " + loanPaidToDatePercentage+ " is available for year is : " + loanPaidDueDateYear.getText());
		
		
	}

	@After
	public void tearDown() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.quit();
	}

}
