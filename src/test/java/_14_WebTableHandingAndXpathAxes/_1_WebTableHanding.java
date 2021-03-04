package _14_WebTableHanding;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _1_WebTableHanding {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://letcode.in/table");
		
		List<WebElement> pricesFromTableListElement = driver.findElements(By.xpath("//table[@id='shopping']//tbody/tr/td[2]"));
		WebElement finalPriceElement = driver.findElement(By.xpath("//table//tfoot/td/b"));
		
		int sum = 0;
		
		for (int i = 0; i < pricesFromTableListElement.size(); i++) 
		{
			sum += Integer.parseInt(pricesFromTableListElement.get(i).getText());
		}
		
		
		if (sum == Integer.parseInt(finalPriceElement.getText())) {
			System.out.println("Total is correct");
		}
		else {
			System.out.println("Total is incorrect");
		}
		
		driver.quit();
		
		
		
	}

}
