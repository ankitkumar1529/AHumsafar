package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import basePage.BasePage;

public class Query_PopUp extends BasePage{
	
	public Query_PopUp(WebDriver driver)
	{
		super(driver);
	}
	
//Please Let Us Know Your Query
	@FindBy(xpath="//select[@id='type']")
	WebElement yourQuer_dropDown;
	
	
	@FindBy(xpath="//input[@id='date_id_2025-03-10']")
	WebElement inputDate;
	
	
	@FindBy(xpath="//label[normalize-space()='6:00 pm']")
	WebElement inputTime;
	
	
	@FindBy(xpath="//button[@id='confirm_schedule']")
	WebElement confirmBtn;
	
//Enter Contact Details
	@FindBy(xpath="//input[@id='name']")
	WebElement txt_name;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement txt_phone;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_email;
	
	@FindBy(xpath="//button[normalize-space()='Schedule Event']")
	WebElement btn_Schedule_Event;
	
//PopUp 

	@FindBy(xpath="//input[@id='codeBox1']")
	WebElement txt_box1;
	@FindBy(xpath="//input[@id='codeBox2']")
	WebElement txt_box2;
	@FindBy(xpath="//input[@id='codeBox3']")
	WebElement txt_box3;
	@FindBy(xpath="//input[@id='codeBox4']")
	WebElement txt_box4;
	@FindBy(xpath="//button[@class='btn btn-danger px-4 validate']")
	WebElement btn_validate;
	
	
	
	public void setYourQueryDropDown()
	{
		Select yourQuery = new  Select(yourQuer_dropDown);
		yourQuery.selectByIndex(2);
	}
	
	public void setDate()
	{
		inputDate.click();
	}
	
	
	public void setTime()
	{
		inputTime.click();
	}
	
	public void clickConifrmBtn()
	{
		confirmBtn.click();
	}
	
	public void setName()
	{
		txt_name.sendKeys("AKKI");
	}
	
	public void setPhone()
	{
		txt_phone.sendKeys("8794563210");
	}
	
	public void setEmail()
	{
		txt_email.sendKeys("AKKI@GMAIL.COM");
	}
	
	public void clickScheduleEventBtn()
	{
		btn_Schedule_Event.click();
	}
	
	public void setOTPBox1()
	{
		txt_box1.sendKeys("1");
	}
	
	public void setOTPBox2()
	{
		txt_box2.sendKeys("1");
	}
	
	public void setOTPBox3()
	{
		txt_box3.sendKeys("1");
	}
	
	public void setOTPBox4()
	{
		txt_box4.sendKeys("1");
	}
	
	public void clickValidateBtn()
	{
		btn_validate.click();
	}
	
}
