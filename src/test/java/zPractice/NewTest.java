package zPractice;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//@Listeners(zPractice.ExtentRpo.class)
public class NewTest {
 public WebDriver driver;
 public Properties p;
 
 
	@Test(priority=1)
  public void f() {
		driver.findElement(By.xpath("//div[@id='call_scheduleModal']//button[@aria-label='Close']")).click();
  }
	
	@Test(priority=2)
	public void m1()
	{
		driver.findElement(By.xpath("//a[@href='https://development.okbima.com/health-insurance']//div[@class='pd_box mb-2']")).click();
	}
	
	@Test(priority=3)
	public void m3()
	{
		driver.findElement(By.xpath("//a[@aria-label='Compare & Buy']")).click();
		driver.findElement(By.xpath("//a[@aria-label='investment-plans']")).click();
	}
	
  @SuppressWarnings("deprecation")
  @BeforeClass
  public void beforeClass(String os , String br) throws IOException {
	  
	  FileReader file =new FileReader("./src//test//resources//config.propertiess");
	  p=new Properties();
	  p.load(file);
	  
	  
	  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	  {
//os		  
		  DesiredCapabilities cap=new DesiredCapabilities();
		  if(os.equalsIgnoreCase("windows"))
		  {
			  cap.setPlatform(Platform.WIN11);
		  }
		  if(os.equalsIgnoreCase("mac"))
		  {
			  cap.setPlatform(Platform.MAC);
			  
		  }
		  if(os.equalsIgnoreCase("Linux"))
		  {
			  cap.setPlatform(Platform.LINUX);
		  }
		  else
		  {
			  System.out.println("Invcalid OS Type");
			  return;
		  }
		  
//br
		  switch(br.toLowerCase())
		  {
		  case "chrome" :cap.setBrowserName("chrome");break;
		  case "edge" : cap.setBrowserName("MicrosoftEdge");break;
		  case "firefox" : cap.setBrowserName("Firefox");break;
		  default : System.out.println("Invalid Browser Type");return;
		  }
		  driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
	  }
	  
	  if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	  {
	  driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL0"));
		driver.manage().window().maximize();
	  }
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
