package zPractice;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetConfig {

	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		FileReader file = new FileReader("./src//test//resources//config.propertiess");
		Properties p=new Properties();
		p.load(file);
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL0"));
		driver.manage().window().maximize();
			  
	}

}
