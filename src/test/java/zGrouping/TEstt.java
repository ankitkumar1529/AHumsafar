package zGrouping;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TEstt {

	WebDriver driver;
	@Parameters({"os","browser"})
	@Test(priority=1, groups={"Sanity"})
	public void TC01() throws InterruptedException  
	{
		driver=new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get("https://development.okbima.com/");
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//div[@id='call_scheduleModal']//button[@aria-label='Close']")).click();
		Thread.sleep(5000);
	}
	
//	@Test(priority=2, groups={"Sanity"})
	public void TC02() 
	{
//	JavascriptExecutor jse=(JavascriptExecutor)driver;
//	jse.executeScript("arguments[0].click;", driver.findElement(By.xpath("//input[@type=\"submit\"]")));
//	driver.findElement(By.xpath("//input[@id='ex_name']")).sendKeys("test");
	driver.findElement(By.xpath("//div[@id='call_scheduleModal']//button[@aria-label='Close']")).click();
	}

}
