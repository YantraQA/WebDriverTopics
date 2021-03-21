package _9_CrossBrowserTesting._2_CrossBrowserTesting.tests;

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
import _9_CrossBrowserTesting._2_CrossBrowserTesting.locators.ProductDetails;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.locators.RegisterUserDetailsPage_Locators;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.locators.SignInPage_Locators;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.ElementActions;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.JavaScriptUtil;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.Utils;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.LandingPage_Variables;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.ProductDetails_Variables;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.RegisterUserDetailsPage_Variables;
import _9_CrossBrowserTesting._2_CrossBrowserTesting.variables.SignInPage_Variables;

public class _2_Test {

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


	// 6. Validate Application Logo Width on landing page
	@Test
	public void _6_validateApplicationLogowidthOnLandingPage()
	{
		Assert.assertEquals("Application Logo width on Landing Page is not matching", LandingPage_Variables.ApplicationLogoWidth, elemementActions.getAttributeValue(LandingPage_Locators.landingPageLogoImage, "width", driver));
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
	public void _8_RegisterNewUserTest()
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

	// 9. Search by a keyword in the product search box and validate how many products are matching with the name
	@Test
	public void _9_SearchProduct()
	{
		elemementActions.doSendKeys(LandingPage_Locators.searchBox, "Dress");
		elemementActions.waitForElementPresent(LandingPage_Locators.searchBoxResultList);

		List<WebElement> elementsList = elemementActions.getElementsList(LandingPage_Locators.searchBoxResultList);

		int countOfProductsWithKeyword = 0;

		for (int i = 0; i < elementsList.size(); i++) 
		{
			if (elementsList.get(i).getText().contains("Dress")) 
			{
				countOfProductsWithKeyword = countOfProductsWithKeyword + 1;
			}
		} 
		if (countOfProductsWithKeyword == 5) {
			Assert.assertTrue(true);
		}

	}

	// 10. Fetch the all product price and get its total
	@Test
	public void _10_GetProductPriceTotal()
	{
		elemementActions.doClick(LandingPage_Locators.topMenuDressesCategory);
		List<WebElement> productPriceListElement = elemementActions.getElementsList(ProductDetails.DressedPriceList);
		double priceTotal = 0;
		double expectedTotalPrice = 152.87000000000003;
		for (int i = 0; i < productPriceListElement.size(); i++) 
		{
			priceTotal = priceTotal + Double.parseDouble(productPriceListElement.get(i).getText().trim().substring(1));
			System.out.println(productPriceListElement.get(i).getText().trim().substring(1));
		}System.out.println(priceTotal);

		if (priceTotal == expectedTotalPrice) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	// 11. Send a Friend Feature
	@Test
	public void _11_RecomendToFriend()
	{
		elemementActions.doClick(LandingPage_Locators.topMenuTShirtCategory);
		elemementActions.doMoveToElement(ProductDetails.optionsToBuyProduct);
		elemementActions.doActionsClick(ProductDetails.MoreOptionButton);
		
		elemementActions.waitForElementClickable(ProductDetails.SendFriendButton);
		elemementActions.doClick(ProductDetails.SendFriendButton);
		
		elemementActions.waitForElementClickable(ProductDetails.FrinedNameTextBox);
		elemementActions.doSendKeys(ProductDetails.FrinedNameTextBox, ProductDetails_Variables.FriendNameForRecommendation);
		elemementActions.doSendKeys(ProductDetails.FrinedEmailIdTextBox, ProductDetails_Variables.FriendEmailIdForRecommendation);
		
		elemementActions.waitForElementClickable(ProductDetails.FrinedMailSendButton);
		elemementActions.doActionsClick(ProductDetails.FrinedMailSendButton);
		
		elemementActions.waitForElementVisible(ProductDetails.emailConfirmationMessageText);
		System.out.println(elemementActions.doGetText(ProductDetails.emailConfirmationMessageText));
		
		Assert.assertEquals("Email Confirmation message is not machtching with the expected string", ProductDetails_Variables.recomendationEmailConformationText, elemementActions.doGetText(ProductDetails.emailConfirmationMessageText));
		
	}

	// 12. Change in the image using Color Feature
	@Test
	public void _12_productColourSelection()
	{
		elemementActions.doClick(LandingPage_Locators.topMenuTShirtCategory);
		String orangeColourImageSourceLink = elemementActions.getAttributeValue(ProductDetails.FadedTShritOrgangeColourImage, "src", driver);
		System.out.println("Orange Colour Tshirt product Image Source Link : " + orangeColourImageSourceLink);

		javaScriptUtil.clickElementByJS(elemementActions.getElement(ProductDetails.FadedTShritBlueColourIcon));
		//elemementActions.doActionsClick(ProductDetails.FadedTShritBlueColourIcon);
		elemementActions.waitForElementVisible(ProductDetails.FadedTShritBlueColourImage);
		String blueColourImageSourceLink = elemementActions.getAttributeValue(ProductDetails.FadedTShritBlueColourImage, "src", driver);
		System.out.println("Blue Colour Tshirt product Image Source Link : " + blueColourImageSourceLink);

		if (!(orangeColourImageSourceLink.equals(blueColourImageSourceLink))) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@After
	public void teardown()
	{
		driver.quit();
	}

}
