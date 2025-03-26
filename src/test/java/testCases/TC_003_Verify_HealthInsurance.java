package testCases;

import org.testng.annotations.Test;

import basePage.BaseClass;
import pageObject.HealthInsurancePlan;

public class TC_003_Verify_HealthInsurance extends BaseClass {
	
	@Test
	public void HealthInsurance_Ipto_quotation()
	{
		HealthInsurancePlan hip=new HealthInsurancePlan(driver);
		hip.closeQueryPopup();
		hip.clickHealthInsurancePlan();
		hip.setInsuredMemberSelf();
		hip.setInsuredMemberSpouse();
		hip.setInsuredMemberSon1();
		hip.setInsuredMemberSon2();
		hip.clickNextBtn();
	}
}
