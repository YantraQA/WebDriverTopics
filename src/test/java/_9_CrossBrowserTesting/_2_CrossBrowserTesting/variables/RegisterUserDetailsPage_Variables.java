package _9_CrossBrowserTesting._2_CrossBrowserTesting.variables;

import _9_CrossBrowserTesting._2_CrossBrowserTesting.utilities.RandomNumberGeneratorUtil;

public class RegisterUserDetailsPage_Variables {
	
	static RandomNumberGeneratorUtil randomUtil = new RandomNumberGeneratorUtil();

	// Variables - Register User Details Page
	public static final String crateAnAccountExpectedText = "CREATE AN ACCOUNT";
	public static final String userFirstName = randomUtil.randomStringGenerator();
	public static final String userLastName = randomUtil.randomStringGenerator();
	public static final String userPassword = "123@Abc";
	public static final String DOBDayValue = "3";
	public static final String DOBMonthValue = "3";
	public static final String DOBYearValue = "2008";
	public static final boolean IsSignUpForNewsLetter = true;
	public static final boolean IsspecialOfferEmailRec = true;
	public static final String AddressFirstName = userFirstName;
	public static final String AddressLastName = userLastName;
	public static final String AddressComanyName = "Unicorn1 Systems";
	public static final String AddressLine1Name = "1773  Backer Street, PO Box 23";
	public static final String AddressLine2Name = "fountain garden";
	public static final String AddressCity = "Los Angeles";
	public static final String AddressState = "New York";
	public static final String AddressZipCode = "10005";
	public static final String AddressAdditionalInfo = "Please Send do the proceedings ASAP";
	public static final String AddressHomePhone = "56457825";
	public static final String AddressMobilePhone = "+16465567479";
	public static final String AdddressAliasAddress = "testDemo@gmail.com";

}
