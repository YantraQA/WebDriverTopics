package _2_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _8_FormFilling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("http://demo.automationtesting.in/Register.html");
		
		WebElement firstNameField = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstNameField.sendKeys("Tom");
		
		WebElement lastNameField = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lastNameField.sendKeys("Peter");
		
		WebElement addressField = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		addressField.sendKeys("301, West Street, NYC");
		
		WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
		emailField.sendKeys("tompeter@gmail.com");
		
		WebElement phoneNumberField = driver.findElement(By.xpath("//input[@type='tel']"));
		phoneNumberField.sendKeys("8956457855");
		
		WebElement genderField = driver.findElement(By.xpath("//input[@value='Male']"));
		genderField.click();
		
		WebElement cricketHobbyRadioBtn = driver.findElement(By.id("checkbox1"));
		cricketHobbyRadioBtn.click();
		
		WebElement hockeyHobbyRadioBtn = driver.findElement(By.id("checkbox3"));
		hockeyHobbyRadioBtn.click();
		
		WebElement passwordField = driver.findElement(By.id("firstpassword"));
		passwordField.sendKeys("123@Xyz");
		
		WebElement ConfirmPasswordField = driver.findElement(By.id("secondpassword"));
		ConfirmPasswordField.sendKeys("123@Xyz");
		
		WebElement submitButton = driver.findElement(By.id("submitbtn"));
		submitButton.click();
		
	}

}
