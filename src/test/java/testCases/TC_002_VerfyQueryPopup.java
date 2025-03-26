package testCases;

import org.testng.annotations.Test;

import basePage.BaseClass;
import pageObject.Query_PopUp;

public class TC_002_VerfyQueryPopup extends BaseClass{
	
	@Test
	public void Verify_Query_PopUp_Upto_Thankyou()
	{
		Query_PopUp popup=new Query_PopUp(driver);
		popup.setYourQueryDropDown();
		popup.setDate();
		popup.setTime();
		popup.clickConifrmBtn();
		popup.setName();
		popup.setPhone();
		popup.setEmail();
		popup.clickScheduleEventBtn();
		popup.setOTPBox1();
		popup.setOTPBox2();
		popup.setOTPBox3();
		popup.setOTPBox4();
		popup.clickValidateBtn();
	}

}
