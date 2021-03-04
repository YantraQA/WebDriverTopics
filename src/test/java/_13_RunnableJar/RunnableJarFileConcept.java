package _13_RunnableJar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunnableJarFileConcept {
	
	static WebDriverWait wait;
	static WebDriver driver;
	public static String UsersName = null;
	public static String messageBodyToBeSent = null;
			
	public static void main(String[] args) throws InterruptedException {

		UsersName = args[0];
		messageBodyToBeSent = args[1];
//		UsersName = "Unknown";
//		messageBodyToBeSent = "hi_there_hi";
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		
		driver.get("https://web.whatsapp.com/");
		
		WebElement searchIconElement = driver.findElement(By.xpath("//span[@data-icon='search']"));
		wait.until(ExpectedConditions.elementToBeClickable(searchIconElement));
		searchIconElement.click();
		
		WebElement serarchBoxEmelent = driver.findElement(By.xpath("//div[@class='_2_1wd copyable-text selectable-text']"));
		wait.until(ExpectedConditions.elementToBeClickable(serarchBoxEmelent));
		serarchBoxEmelent.clear();
		serarchBoxEmelent.sendKeys(UsersName);
		
		WebElement userNameElement = driver.findElement(By.xpath("//span[text()='"+UsersName+"']" ));
		wait.until(ExpectedConditions.elementToBeClickable(userNameElement));
		userNameElement.click();
		
		WebElement sendTextBoxElement = driver.findElement(By.xpath("//div[@data-tab='6']"));
		wait.until(ExpectedConditions.elementToBeClickable(sendTextBoxElement));
		sendTextBoxElement.sendKeys(messageBodyToBeSent);
		
		
		WebElement messageSendButtonElement = driver.findElement(By.xpath("//span[@data-testid='send' and @data-icon='send']"));
		wait.until(ExpectedConditions.elementToBeClickable(sendTextBoxElement));
		messageSendButtonElement.click();
		
		WebElement threeDotMenuElement = driver.findElement(By.xpath("(//span[@data-testid='menu' and @data-icon='menu'])[1]"));
		wait.until(ExpectedConditions.elementToBeClickable(threeDotMenuElement));
		threeDotMenuElement.click();
		
		WebElement logOutElement = driver.findElement(By.xpath("//ul[@class='_19rjv']//li//div[text()='Log out']"));
		wait.until(ExpectedConditions.elementToBeClickable(logOutElement));
		logOutElement.click();
	
		driver.quit();
		
	}

}
