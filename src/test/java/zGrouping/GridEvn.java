package zGrouping;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GridEvn {
	
	WebDriver driver;
	Properties p;
	
	@Parameters({"os","browser"})
	@BeforeClass
	public void setup(String os, String br) throws IOException
	{
	    FileReader file=new FileReader("./src//test//resources//config.propertiess");
	    p=new Properties();
	    p.load(file);
	 if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	 {
		 DesiredCapabilities cap= new DesiredCapabilities();
		 
		 if(os.equalsIgnoreCase("windows"))
			{
				cap.setPlatform(Platform.WIN11);
				
			}
			else if(os.equalsIgnoreCase("Linex"))
			{
				cap.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				cap.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching OS");
				return;			
			}
/*		 switch(os.toLowerCase())
		 {
		 case "windows" :cap.setPlatform(Platform.WIN11);break;
		 case "linux" :cap.setPlatform(Platform.LINUX);break;
		 case "mac": cap.setPlatform(Platform.MAC);break;
		 default : System.out.println("Invalid OS....");return;
		 }
*/		 
		 switch(br.toLowerCase())
		 {
		 case "chrome" :cap.setBrowserName("chrome");break;
		 case "edge"  :cap.setBrowserName("MicrosoftEdge");break;
		 case "firefox" :cap.setBrowserName("firefox");break;
		 default : System.out.println("Invalid Browser.....");return;
		 
		 }
		 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
	 }
	 if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	 {
		 switch(br.toLowerCase())
		 {
		 
		 case "edge" : driver=new EdgeDriver();break;
		 case "chrome" : driver=new ChromeDriver();break;
		 case "firefox" : driver=new FirefoxDriver();break;
		 default : System.out.println("Invalid Browser........");return;
		 }
	 }
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
	}

//	@Parameters({"os","browser"})
	@AfterClass(enabled=false)
	public void teardown()
	{
		driver.close();
	}
	
//	@Parameters({"os","browser"})
	@Test
	public void gridTest()
	{
		//*[@id="call_scheduleModal"]/div/div/div[1]/button
		driver.findElement(By.xpath("//body/div[contains(@class,'pt-1 health-one-section')]/div[contains(@class,'mid-container')]/div[contains(@class,'row all-box pet_frm_bg p-4')]/div[contains(@class,'p-0 position-relative')]/div[@class='form-right-box position-relative pa-form-right']/form[@id='health_form']/div[@class='proposal-form-holder prsl_frm_on']/fieldset[@id='form1']/div[@class='row']/div[1]/label[1]/span[1]")).click();
	driver.findElement(By.xpath("//input[contains(@class,'next action-button get-quote-btn new-next-button m-auto mt-2')]")).click();
	}
	
}
