package _2_Locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _9_EnteringDataAndValidating {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		String textToBeEntered = "Selenium Web Automation Tool";

		WebElement textField = driver.findElement(By.id("user-message"));
		textField.sendKeys(textToBeEntered);
		
		WebElement textSubmitButton = driver.findElement(By.xpath("(//button[@type='button' and @class='btn btn-default'])[1]"));
		textSubmitButton.click();
		
		WebElement outputText = driver.findElement(By.id("display"));
		String textActual = outputText.getText();
		
		if (textActual.equals(textToBeEntered)) {
			System.out.println("Output is correct,Input text value is equal to the output text value");
		}
		else {
			System.out.println("Output is not correct,Input text value is not equal to the output text value");
		}
		
		String variableA = "10";
		String variableB = "20";
		
		// Converting the String values in to actual numeric values
		int a = Integer.parseInt(variableA);
		int b = Integer.parseInt(variableB);
		
		WebElement textFieldA = driver.findElement(By.id("sum1"));
		textFieldA.sendKeys(variableA);
		
		WebElement textFieldB = driver.findElement(By.id("sum2"));
		textFieldB.sendKeys(variableB);
		
		WebElement getTotalButton = driver.findElement(By.xpath("(//button[@type='button' and @class='btn btn-default'])[2]"));
		getTotalButton.click();
		
		WebElement totalText = driver.findElement(By.id("displayvalue"));
		String totalTextValue = totalText.getText();
		
		int total = Integer.parseInt(totalTextValue);
		
		if ((a+b)==total) {
			System.out.println("Output is total is correct");
		}
		else {
			System.out.println("Output is total is incorrect");
		}
		
		driver.quit();
		
	}

}
