package _9_CrossBrowserTesting._2_CrossBrowserTesting.locators;

import org.openqa.selenium.By;

public class RegisterUserDetailsPage_Locators {

	// Locators - Create Account Page
	public static By CreateAnAccountTextElement = By.xpath("//div[@id='noSlide']/h1[contains(text(),'Create an account')]");
	public static By maleGenderRadioButtonElement = By.id("id_gender1");
	public static By userFirstNameTextboxElement = By.id("customer_firstname");
	public static By userLastNameTextboxElement = By.id("customer_lastname");
	public static By userPasswordTextboxElement = By.id("passwd");
	public static By userDOBDayDropDownElement = By.id("days");
	public static By userDOBMonthDropDownElement = By.id("months");
	public static By userDOBYearDropDownElement = By.id("years");
	public static By signUpForNewsLetterCheckBoxElement = By.id("newsletter");
	public static By specialOfferEmailRecCheckBoxElement = By.id("optin");
	public static By AddressFirstNameTextBoxElement = By.id("firstname");
	public static By AddressLastNameTextBoxElement = By.id("lastname");
	public static By AddressComanyNameTextBoxElement = By.id("company");
	public static By AddressLine1TextBoxElement = By.id("address1");
	public static By AddressLine2TextBoxElement = By.id("address2");
	public static By AddressCityTextBoxElement = By.id("city");
	public static By AddressStateDropDownElement = By.id("id_state");
	public static By AddressZipCodeTextBoxElement = By.id("postcode");
	public static By AddressCountryDropDownElement = By.id("id_country");
	public static By AddressAdditionalInfoTextBoxElement = By.id("other");
	public static By AddressHomePhoneTextBoxElement = By.id("phone");
	public static By AddressMobilePhoneTextBoxElement = By.id("phone_mobile");
	public static By AdddressAliasAddressTextBoxElement = By.id("alias");
	public static By registerFormButtonElement = By.id("submitAccount");

}
