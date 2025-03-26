package zCaptureScreenn;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CaptureScreenShots {
	
	 public WebDriver driver;
	 public String akki;
		@Test(groups= {"Regression"})
	  public void f() {
			driver.findElement(By.xpath("//div[@id='call_scheduleModal']//button[@aria-label='Close']")).click();
			
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time
		     
		    String x="akki";
			TakesScreenshot tsc=(TakesScreenshot)driver;
			File sourcefile=tsc.getScreenshotAs(OutputType.FILE);
			File targetfile=new File(System.getProperty("user.dir")+"//screenshots//" +x +timeStamp+".png");
			sourcefile.renameTo(targetfile);
	  }
	  @BeforeClass
	  public void beforeClass() {
		  driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().deleteAllCookies();
			driver.get("https://development.okbima.com/");
			driver.manage().window().maximize();
	  }

	  @AfterClass
	  public void afterClass() {
		  driver.close();
	  }

}
