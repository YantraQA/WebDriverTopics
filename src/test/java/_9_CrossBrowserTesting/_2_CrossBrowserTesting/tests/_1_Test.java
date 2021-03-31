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

import _9_CrossBrowserTesting._2_CrossBrowserTesting.locators.LandingPage_Locators;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.ElementActions;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.JavaScriptUtil;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.Utils;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.LandingPage_Variables;

public class _1_Test {

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

	@After
	public void teardown()
	{
		driver.quit();
	}


}
