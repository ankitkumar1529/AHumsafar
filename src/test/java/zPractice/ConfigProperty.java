package zPractice;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ConfigProperty {
	
	WebDriver driver;
	Properties p;
	@Test
	public void testing() throws IOException
	{
		
		FileReader file=new FileReader("./src//test//resources//config.propertiess");
		p=new Properties();
		p.load(file);
	
		
		driver =new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL0"));
		driver.manage().window().maximize();
	}

}
