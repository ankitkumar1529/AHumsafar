package zNewTest;

import org.testng.annotations.Test;

public class SeleniumGridTC001 extends SeleniumGridBaseClass{
	
	@Test()
	public void Test_Ask_and_Expert()
	{
		SeleniumGridPOM tc01=new SeleniumGridPOM(driver);
		tc01.setEmail(randomAlphabets().toUpperCase());
		tc01.setPassword(randomNumber());
		tc01.clickLoginBtn();
		
	}

}
