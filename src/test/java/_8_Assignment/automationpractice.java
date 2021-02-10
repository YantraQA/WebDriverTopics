package _8_Assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class automationpractice {

	// Variables - Landing Page
	String ExpectedRedirectedURL = "http://automationpractice.com/index.php";
	String LandingPageTitle = "My Store";
	
	// Variables - SignIn Page
	String SignInPageTitle = "Login - My Store";
	String NewUserEmailID = "DemoUser11@gmail.com";
	
	// Variables - Register User Details Page
	String crateAnAccountExpectedText = "CREATE AN ACCOUNT";
	

	// Locators - Landing Page
	By SigninButtonElement = By.xpath("//div/a[contains(text(),'Sign in')]");
	By ProductCatoegoryList = By.xpath("//div[@id='block_top_menu']/ul/li/a");
	By landingPageLogoImage = By.xpath("//img[@class='logo img-responsive']");
	
	// Locators - Singin Page
	By emailIdInputFieldElement = By.xpath("//input[@id='email_create']");
	By createAnAccountButtonElement = By.xpath("//button[@id='SubmitCreate']");
	
	// Locators - Create Account Page
	By CreateAnAccountTextElement = By.xpath("//div[@id='noSlide']/h1[contains(text(),'Create an account')]");
	

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/");
	}

//	// 1. Url Redirection Test
//	@Test
//	public void _1_urlTest()
//	{
//		Assert.assertEquals("Url redirection is not as expected",ExpectedRedirectedURL, driver.getCurrentUrl());
//	}
//
//	// 2. Landing Page Title Test
//	@Test
//	public void _2_pageTitleTest()
//	{
//
//		Assert.assertEquals("Page title is incorrect",LandingPageTitle, driver.getTitle());
//	}
//
//	// 3. Validate for all categories is displayed
//	@Test
//	public void _3_allCategoriesDisplayedTest()
//	{
//		ArrayList<String> expectedCategoryList = new ArrayList<>();
//		expectedCategoryList.add("WOMEN");
//		expectedCategoryList.add("DRESSES");
//		expectedCategoryList.add("T-SHIRTS");
//		
//		List<WebElement> actualProductCategoryList = driver.findElements(ProductCatoegoryList);
//		
//		for (int i = 0; i < expectedCategoryList.size(); i++) 
//		{
//			Assert.assertEquals("Product index no " + (i+1) + " is not matching with expected",expectedCategoryList.get(i), actualProductCategoryList.get(i).getText());
//		}
//
//	}
//	
//	// 4. Validate Application Logo on landing page
//	@Test
//	public void _4_validateApplicationLogoOnLandingPage()
//	{
//		WebElement landingPageLogo = driver.findElement(landingPageLogoImage);
//
//		Assert.assertEquals("Apllication Logo on Landing Page is not Displayed",true, landingPageLogo.isDisplayed());
//
//	}
//	
//	// 5. Validate Application Logo Height on landing page
//	@Test
//	public void _5_validateApplicationLogoHeightOnLandingPage()
//	{
//		WebElement landingPageLogo = driver.findElement(landingPageLogoImage);
//
//		Assert.assertEquals("Apllication Logo height on Landing Page is not matching","99", landingPageLogo.getAttribute("height"));
//
//	}
//	
//	// 6. Validate Application Logo Width on landing page
//	@Test
//	public void _6_validateApplicationLogowidthOnLandingPage()
//	{
//		WebElement landingPageLogo = driver.findElement(landingPageLogoImage);
//
//		Assert.assertEquals("Apllication Logo width on Landing Page is not matching","350", landingPageLogo.getAttribute("width"));
//	}
//
	// 7. SignIn page title validation test
	@Test
	public void _7_SignInPageTitleValidationTest()
	{
		WebElement SigninButton = driver.findElement(SigninButtonElement);
		SigninButton.click();
		
		Assert.assertEquals("Signin Page Title is not matching",SignInPageTitle, driver.getTitle());
	}
	
	// 8. Register User With New Email Id on SignIn Page
	@Test
	public void _8_RegisterNewUserTest()
	{
		_7_SignInPageTitleValidationTest();
		
		WebElement emailIdInputField = driver.findElement(emailIdInputFieldElement);
		emailIdInputField.sendKeys(NewUserEmailID);
		
		WebElement createAnAccountButton = driver.findElement(createAnAccountButtonElement);
		createAnAccountButton.click();
		
		WebElement crateAnAccountText = driver.findElement(CreateAnAccountTextElement);
		
		Assert.assertEquals("\"Create an account\" text is not displayed on register user details page",crateAnAccountExpectedText, crateAnAccountText.getText());
	}
	
	
	
	



	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}

}
