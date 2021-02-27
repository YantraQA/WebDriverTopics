package _9_CrossBrowserTesting._2_CrossBrowserTesting.variables;

import java.util.ArrayList;

public class LandingPage_Variables {
	
	// Variables - Landing Page
	public static final String ExpectedRedirectedURL = "http://automationpractice.com/index.php";
	public static final String LandingPageTitle = "My Store";
	public static final String ApplicationLogoWidth = "350";
	public static final String ApplicationLogoHeight = "99";
	
	public static ArrayList<String> ExpectedMainProductCategories()
	{
		ArrayList<String> expectedCategoryList = new ArrayList<>();
		expectedCategoryList.add("WOMEN");
		expectedCategoryList.add("DRESSES");
		expectedCategoryList.add("T-SHIRTS");
		
		return expectedCategoryList;
	}

}
