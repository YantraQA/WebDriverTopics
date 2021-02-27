package _9_CrossBrowserTesting._2_CrossBrowserTesting.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import _9_CrossBrowserTesting._2_CrossBrowserTesting.locators.AfterRegistartionPage_Locators;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.locators.LandingPage_Locators;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.locators.RegisterUserDetailsPage_Locators;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.locators.SignInPage_Locators;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.ElementActions;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.JavaScriptUtil;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.Utils;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.LandingPage_Variables;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.RegisterUserDetailsPage_Variables;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.SignInPage_Variables;

/**
 * 
 * @author Sarang Holey
 * 
 */


public class automationpractice {
	
	WebDriver driver;
	WebDriverWait wait;
	Properties prop;
	Utils utils;
	ElementActions elemementActions;
	JavaScriptUtil javaScriptUtil;

	@Before
	public void setUp()
	{
		utils = new Utils();
		prop = utils.init_prop();
		driver = utils.init_driver(prop);
		elemementActions = new ElementActions(driver);
		wait = new WebDriverWait(driver, Integer.parseInt(prop.getProperty("WebDriverWaitTimeout")));
		javaScriptUtil = new JavaScriptUtil(driver);
	}

	// 1. Url Redirection Test
	@Test
	public void _1_urlTest()
	{
		Assert.assertEquals("Url redirection is not as expected",LandingPage_Variables.ExpectedRedirectedURL, elemementActions.doGetcurrentURL());
		System.out.println("Test -> 1. Url Redirection Test Passed");
	}

	// 2. Landing Page Title Test
	@Test
	public void _2_pageTitleTest()
	{

		Assert.assertEquals("Page title is incorrect",LandingPage_Variables.LandingPageTitle, elemementActions.doGetPageTitle());
		System.out.println("Test -> 2. Landing Page Title Test passed");
	}

	// 3. Validate for all categories is displayed
	@Test
	public void _3_allCategoriesDisplayedTest()
	{
		ArrayList<String> expectedCategoryList = LandingPage_Variables.ExpectedMainProductCategories();
		
		List<WebElement> actualProductCategoryList = elemementActions.getElementsList(LandingPage_Locators.ProductCatoegoryList);
		
		for (int i = 0; i < expectedCategoryList.size(); i++) 
		{
			Assert.assertEquals("Product index no " + (i+1) + " is not matching with expected",expectedCategoryList.get(i), actualProductCategoryList.get(i).getText());
		}
		
		System.out.println("Test -> 3. Validate for all categories is displayed passed");
	}
	
	// 4. Validate Application Logo on landing page is displayed
	@Test
	public void _4_validateApplicationLogoOnLandingPage()
	{
		Assert.assertEquals("Application Logo on Landing Page is not Displayed",true, elemementActions.doIsDisplayed(LandingPage_Locators.landingPageLogoImage));
		System.out.println("Test -> 4. Validate Application Logo on landing page is displayed passed");
	}
	
	// 5. Validate Application Logo Height on landing page
	@Test
	public void _5_validateApplicationLogoHeightOnLandingPage()
	{
		Assert.assertEquals("Apllication Logo height on Landing Page is not matching",LandingPage_Variables.ApplicationLogoHeight, elemementActions.getAttributeValue(LandingPage_Locators.landingPageLogoImage, "height", driver));
		System.out.println("Test -> 5. Validate Application Logo Height on landing page passed");
	}
	
	// 6. Validate Application Logo Width on landing page
	@Test
	public void _6_validateApplicationLogowidthOnLandingPage()
	{
		Assert.assertEquals("Apllication Logo width on Landing Page is not matching", LandingPage_Variables.ApplicationLogoWidth, elemementActions.getAttributeValue(LandingPage_Locators.landingPageLogoImage, "width", driver));
		System.out.println("Test -> 6. Validate Application Logo Width on landing page passed");
	}

	// 7. SignIn page title validation test
	@Test
	public void _7_SignInPageTitleValidationTest()
	{
		elemementActions.doClick(LandingPage_Locators.SigninButtonElement);
		
		Assert.assertEquals("Signin Page Title is not matching", SignInPage_Variables.SignInPageTitle, elemementActions.doGetPageTitle());
		System.out.println("Test -> 7. SignIn page title validation test passed");
	}
	
	// 8. Register User With New Email Id on SignIn Page
	@Test
	public void _8_RegisterNewUserTest() throws InterruptedException
	{
		_7_SignInPageTitleValidationTest();
		
		elemementActions.doSendKeys(SignInPage_Locators.emailIdInputFieldElement, SignInPage_Variables.NewUserEmailID);
		
		elemementActions.doClick(SignInPage_Locators.createAnAccountButtonElement);
		
		Assert.assertEquals("\"Create an account\" text is not displayed on register user details page",RegisterUserDetailsPage_Variables.crateAnAccountExpectedText, elemementActions.doGetText(RegisterUserDetailsPage_Locators.CreateAnAccountTextElement));
		
		elemementActions.doClick(RegisterUserDetailsPage_Locators.maleGenderRadioButtonElement);

		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.userFirstNameTextboxElement, RegisterUserDetailsPage_Variables.userFirstName);

		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.userLastNameTextboxElement, RegisterUserDetailsPage_Variables.userLastName);

		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.userPasswordTextboxElement, RegisterUserDetailsPage_Variables.userPassword);

		elemementActions.selectByValueFromDropDown(RegisterUserDetailsPage_Locators.userDOBDayDropDownElement, RegisterUserDetailsPage_Variables.DOBDayValue);

		elemementActions.selectByValueFromDropDown(RegisterUserDetailsPage_Locators.userDOBMonthDropDownElement, RegisterUserDetailsPage_Variables.DOBMonthValue);

		elemementActions.selectByValueFromDropDown(RegisterUserDetailsPage_Locators.userDOBYearDropDownElement, RegisterUserDetailsPage_Variables.DOBYearValue);
		
		if (RegisterUserDetailsPage_Variables.IsSignUpForNewsLetter) 
		{
			elemementActions.doClick(RegisterUserDetailsPage_Locators.signUpForNewsLetterCheckBoxElement);
		}
		
		if (RegisterUserDetailsPage_Variables.IsspecialOfferEmailRec) 
		{
			elemementActions.doClick(RegisterUserDetailsPage_Locators.specialOfferEmailRecCheckBoxElement);
		}
			
		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.AddressComanyNameTextBoxElement, RegisterUserDetailsPage_Variables.AddressComanyName);
		
		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.AddressLine1TextBoxElement, RegisterUserDetailsPage_Variables.AddressLine1Name);

		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.AddressLine2TextBoxElement, RegisterUserDetailsPage_Variables.AddressLine2Name);

		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.AddressCityTextBoxElement, RegisterUserDetailsPage_Variables.AddressCity);

		elemementActions.selectByVisibleTextFromDropDown(RegisterUserDetailsPage_Locators.AddressStateDropDownElement, RegisterUserDetailsPage_Variables.AddressState);

		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.AddressZipCodeTextBoxElement, RegisterUserDetailsPage_Variables.AddressZipCode);

		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.AddressAdditionalInfoTextBoxElement, RegisterUserDetailsPage_Variables.AddressAdditionalInfo);
		
		elemementActions.doSendKeys(RegisterUserDetailsPage_Locators.AddressMobilePhoneTextBoxElement, RegisterUserDetailsPage_Variables.AddressMobilePhone);

		elemementActions.doClick(RegisterUserDetailsPage_Locators.registerFormButtonElement);

		elemementActions.waitForElementVisible(AfterRegistartionPage_Locators.registeredUserNameDisplayElement);
		Assert.assertEquals("Registered User First Name And Last Name is not displayed correctly after registration", RegisterUserDetailsPage_Variables.userFirstName + " " + RegisterUserDetailsPage_Variables.userLastName,
				elemementActions.doGetText(AfterRegistartionPage_Locators.registeredUserNameDisplayElement));
		
		System.out.println("User Registered Successfully as -> " + RegisterUserDetailsPage_Variables.userFirstName + " " + RegisterUserDetailsPage_Variables.userLastName);
		
		System.out.println("Test -> 8. Register User With New Email Id on SignIn Page passed");
		
	}
		
	@After
	public void teardown()
	{
		driver.quit();
	}
	

}
