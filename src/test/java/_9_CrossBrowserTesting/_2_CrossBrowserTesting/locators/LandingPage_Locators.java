package _9_CrossBrowserTesting._2_CrossBrowserTesting.locators;

import org.openqa.selenium.By;

public class LandingPage_Locators {

	// Locators - Landing Page
	public static By SigninButtonElement = By.xpath("//div/a[contains(text(),'Sign in')]");
	public static By ProductCatoegoryList = By.xpath("//div[@id='block_top_menu']/ul/li/a");
	public static By landingPageLogoImage = By.xpath("//img[@class='logo img-responsive']");
	public static By searchBox = By.id("search_query_top");
	public static By searchBoxResultList = By.xpath("//div[@class='ac_results']/ul/li");
	public static By topMenuDressesCategory = By.xpath("(//div[@id='block_top_menu']//a[text()='Dresses' and @title='Dresses'])[2]");
	public static By topMenuTShirtCategory = By.xpath("(//div[@id='block_top_menu']//a[text()='T-shirts'])[2]");
	
	// Social Media Links
	public static By faceBookLink = By.xpath("//span[text()='Facebook']/parent::a");
	public static By twitterLink = By.xpath("//span[text()='Twitter']/parent::a");
	public static By youTubeLink = By.xpath("//span[text()='Youtube']/parent::a");
	
	// Newsletter subscription
	public static By newsLetterEmailTextBoxElement = By.xpath("//input[@id='newsletter-input']");
	public static By newsLetterEmailSendButtonElement = By.xpath("//button[@name='submitNewsletter']");
	public static By newsLetterSubscriptionSuccessAlertElement = By.xpath("//p[@class='alert alert-success']");
	
		
}
