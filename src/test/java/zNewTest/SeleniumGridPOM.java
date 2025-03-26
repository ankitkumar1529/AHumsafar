package zNewTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SeleniumGridPOM extends SeleniumGridBasePage{
	
	public SeleniumGridPOM(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}



	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtEmail;

	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPsd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLogin;
	
	
	public void setEmail(String eml)
	{
		txtEmail.sendKeys(eml);
	}
	
	public void setPassword(String psd)
	{
		txtPsd.sendKeys(psd);
	}
	
	
	public void clickLoginBtn()
	{
		btnLogin.click();
	}
}
