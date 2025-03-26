package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePage.BasePage;

public class HealthInsurancePlan extends BasePage{
	
	public HealthInsurancePlan(WebDriver driver)
	{
		super(driver);
	}
//Close Query Popup	
	@FindBy(xpath="//div[@id='call_scheduleModal']//button[@aria-label='Close']")
	WebElement btn_closed;
//Choose Health Insurance Plan From HomePage	
	@FindBy(xpath="//ul[@class='mt-lg-4 mt-md-4 pd_wraper d-flex']//a[normalize-space()='Health Insurance']")
	WebElement lnk_healthInsurancePlan;
	
// Health Insurance Plan Form Page Step 1 - Cover Details
	@FindBy(xpath="//body/div[contains(@class,'pt-1 health-one-section')]/div[contains(@class,'mid-container')]/div[contains(@class,'row all-box pet_frm_bg p-4')]/div[contains(@class,'p-0 position-relative')]/div[contains(@class,'form-right-box position-relative pa-form-right')]/form[@id='health_form']/div[contains(@class,'proposal-form-holder prsl_frm_on')]/fieldset[@id='form1']/div[2]/div[1]/label[1]/span[1]")
	WebElement btn_self;
	
	@FindBy(xpath="//img[@id='spouseImg']")
	WebElement btn_spouse;
	
	@FindBy(xpath="//div[contains(@class,'singleSon')]//span[contains(@class,'custom-checkbox-text number-drop-border')]")
	WebElement btn_son1;
	
	@FindBy(xpath="//span[@id='sonAdd']")
	WebElement btn_son2;
	
	@FindBy(xpath="//input[contains(@class,'next action-button get-quote-btn new-next-button m-auto mt-2')]")
	WebElement btn_next;
	
//  Health Insurance Plan Form Page Step 2 - Proposer Details
	@FindBy(xpath="//input[@placeholder='Name*']")
	WebElement txt_name;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement txt_phone;
	
	@FindBy(xpath="//input[@id='dob']")
	WebElement txt_dob;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_email;
	
	@FindBy(xpath="//input[@id='location']")
	WebElement txt_location;
	
	@FindBy(xpath="//fieldset[@id='form2']//input[contains(@name,'next')]")
	WebElement btn_next2;
	
	public void closeQueryPopup()
	{
		btn_closed.click();
	}
	
	public void clickHealthInsurancePlan()
	{
		lnk_healthInsurancePlan.click();
	}
	
	public void setInsuredMemberSelf()
	{
		btn_self.click();
	}
	
	public void setInsuredMemberSpouse()
	{
		btn_spouse.click();
	}
	
	public void setInsuredMemberSon1()
	{
		btn_son1.click();
	}
	
	public void setInsuredMemberSon2()
	{
		btn_son2.click();
	}
	
	public void clickNextBtn()
	{
		btn_next.click();
	}
	
	public void setName()
	{
		txt_name.sendKeys("test okbima");
	}
	
	public void setPhone()
	{
		txt_phone.sendKeys("9876543210");
	}
	
	public void setDOB()
	{
		txt_dob.sendKeys("01021999");
	}
	
	public void setEmail()
	{
		txt_email.sendKeys("test@okbima.com");
	}
	
	public void setLoaction()
	{
		txt_location.sendKeys("New Delhi");
	}
	
	public void clickNextBtn2()
	{
		btn_next2.click();
	}

}
