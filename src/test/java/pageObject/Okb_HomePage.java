package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class Okb_HomePage extends BasePage{
	
	public Okb_HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//div[@id='call_scheduleModal']//button[@aria-label='Close']")
	WebElement btn_close;
	
	@FindBy(xpath="//ul[@class='mt-lg-4 mt-md-4 pd_wraper d-flex']//a[normalize-space()='Health Insurance']")
	WebElement lnk_healthInsurance;
	
	public void closeQueryPopUp()
	{
		btn_close.click();
	}
	
	public void clickHealthInsurance()
	{
		lnk_healthInsurance.click();
	}
}
