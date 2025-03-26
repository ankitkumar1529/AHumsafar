package zNewTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class SeleniumGridBaseClass {
	
	public WebDriver driver;
	public Properties p;
	@Parameters({"os", "browser"})
	@BeforeClass
	public void setup(String os, String br) throws IOException
	{
	 FileReader file=new FileReader("./src//test//resources//config.propertiess");	
		p=new Properties();
		p.load(file);
	  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
	  {
		 
			
			DesiredCapabilities cap=new DesiredCapabilities();
			switch(os.toLowerCase())
			{
			case "windows" :cap.setPlatform(Platform.WIN11);break;
			case "Linux" :cap.setPlatform(Platform.LINUX);break;
			case "mac" : cap.setPlatform(Platform.MAC);break;
			default : System.out.println("Invalid OS....");return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome" : cap.setBrowserName("chrome");
			case "edge" :cap.setBrowserName("MicrosoftEdge");break;
			case "firefox" : cap.setBrowserName("Firefox");break;
			default : System.out.println("Invalid Browser.....");
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
	  }	
			
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome" : driver=new ChromeDriver();break;
			case "edge" :driver=new EdgeDriver();break;
			case "firefox" : driver=new FirefoxDriver();break;
			default : System.out.println("Invalid Browser....");return;
			}
		}
		
		
//		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL3"));
		driver.manage().window().maximize();
	}
	
//	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	public String randomAlphabets()
	{
		String genAlphabets=RandomStringUtils.randomAlphabetic(5);
		return genAlphabets;
	}
	
	public String randomNumber()
	{
		String genNumber=RandomStringUtils.randomNumeric(10);
		return genNumber;
	}
	
	public String randomAlphaNumerci()
	{
		String genAlphaNumeric=RandomStringUtils.randomAlphanumeric(5);
		return genAlphaNumeric;
	}
	
	public String customizedAlphaNumeric()
	{
		String genAlphabets=RandomStringUtils.randomAlphabetic(5);
		String genNumber=RandomStringUtils.randomNumeric(10);
		return (genAlphabets+genNumber);
	}
	
	public String captureScreenshot()
	{
//		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot tss=(TakesScreenshot)driver;
		File sourcefile=tss.getScreenshotAs(OutputType.FILE);
		File targetfile=new File("./screenshots//"+"//ikka.png");
		sourcefile.renameTo(targetfile);
		return null;
		
		
		
	}

	
}
