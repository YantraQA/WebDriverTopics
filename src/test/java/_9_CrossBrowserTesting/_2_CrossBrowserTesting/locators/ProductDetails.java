package _9_CrossBrowserTesting._2_CrossBrowserTesting.locators;

import org.openqa.selenium.By;

public class ProductDetails {
	
	// Locators - ProductDetails Page - Dresses
	public static By DressedPriceList = By.xpath("//div[@class='right-block']//div[@itemprop='offers']//span[@itemprop='price']");
	
	// Locators - ProductDetails Page - TShirt
	public static By optionsToBuyProduct = By.xpath("//div[@class='right-block']");
	public static By MoreOptionButton = By.xpath("//span[text()='More']");
	public static By SendFriendButton = By.xpath("//a[@id='send_friend_button']");
	public static By FrinedNameTextBox = By.xpath("//input[@id='friend_name']");
	public static By FrinedEmailIdTextBox = By.xpath("//input[@id='friend_email']");
	public static By FrinedMailSendButton = By.xpath("//button[@id='sendEmail']");
	//public static By emailConfirmationMessageText = By.xpath("(//div[@class='fancybox-inner']/p)[1]");
	public static By emailConfirmationMessageText = By.xpath("//div[@class='fancybox-inner']/h2/following-sibling::p[1]");
	
	public static By FadedTShritOrgangeColourImage = By.xpath("//img[@title='Faded Short Sleeve T-shirts']");
	public static By FadedTShritBlueColourIcon = By.xpath("//a[@id='color_2']");
	public static By FadedTShritBlueColourImage = By.xpath("//span[@id='view_full_size']//img[@title='Faded Short Sleeve T-shirts']");
	
	
	

}
