package testCases;

import org.testng.annotations.Test;

import basePage.BaseClass;
import pageObject.Okb_HomePage;

public class TC_001_Close_popup extends BaseClass{
	
	
	@Test
	public void Able_to_close_query_popup()     // Verify that able to close Query pop-up
	{
		Okb_HomePage closeQuery=new Okb_HomePage(driver);
		closeQuery.closeQueryPopUp();
	}

}
