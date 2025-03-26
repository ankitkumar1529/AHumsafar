package basePage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@SuppressWarnings("deprecation")
	@Parameters({"os", "browser"})
	public void starup(String os, String br) throws IOException
	{
		FileReader file = new FileReader("./src/test//resources//config.propertiess");    // /AHumsafar/src/test/resources/config.properties
		p=new Properties();                                                               //("./src//test//resources//config.properties");
		p.load(file);
		
		logger =LogManager.getLogger(this.getClass());
		
/*		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities=new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
				
			}
			else if(os.equalsIgnoreCase("Linex"))
			{
				capabilities.setPlatform(Platform.LINUX);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else
			{
				System.out.println("No Matching OS");
				return;			
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			default:System.out.println("No Matching Browser");return;
			}
			
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}
*/		
//		if(p.getProperty("execution_evn").equalsIgnoreCase("local"))
			switch(br.toLowerCase())
			{
			case "chrome": driver= new ChromeDriver();break;
			case "edge": driver=new EdgeDriver();break;
			case "firefox": driver=new FirefoxDriver();break;
			default:System.out.println("Invalid Browser ....");return;
		
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL0"));
		driver.manage().window().maximize();
	}
	
	
	@AfterClass(enabled=false)
	public void tearDown()
	{
		driver.close();
	}
	
	public String randomeAlphabets()
	{
		String generatedAlphabets=RandomStringUtils.randomAlphabetic(5);
		return generatedAlphabets;
		
	}
	
	public String randomeNumbers()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(5);
		return generatedNumber;
		
	}
	
	public String randomeAlphaNumeric()
	{
		String generatedAlphabets=RandomStringUtils.randomAlphabetic(5);
		String generatedNumber=RandomStringUtils.randomNumeric(5);
		return (generatedAlphabets+generatedNumber);
		
	}
	
	public String captureScreen(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File sourceFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_"+ timeStamp +".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		
	}
	
	
}
