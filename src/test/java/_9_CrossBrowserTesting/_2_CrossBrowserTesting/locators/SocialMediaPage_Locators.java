package _9_CrossBrowserTesting._2_CrossBrowserTesting.locators;

import org.openqa.selenium.By;

public class SocialMediaPage_Locators {
	
	// Locators - Social Media Page Locators
	public static By youtubeChannelNameElement = By.xpath("//div[@id='text-container']/child::yt-formatted-string[text()='Selenium Framework']");
	public static By twitterChannelNameElement = By.xpath("//div[@data-testid='titleContainer']//span[text()='Selenium Framework']");
	public static By facebookChannelNameElement = By.xpath("(//span[text()='Selenium Framework'])[1]");
	
}
