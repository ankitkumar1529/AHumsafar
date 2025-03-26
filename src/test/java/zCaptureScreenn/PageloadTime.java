package zCaptureScreenn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageloadTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub        
		
//		System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");  

        // Initialize ChromeDriver  
        WebDriver driver = new ChromeDriver();  
        driver.manage().window().maximize();

        // URL to check  
        String url = "https://www.okbima.com/health-insurance-quotes/MzQ5NDc=";  

        // Record start time  
        long start = System.currentTimeMillis();  

        // Navigate to the URL  
        driver.get(url);  

        // Record end time  
        long finish = System.currentTimeMillis();  

        // Calculate page load time  
        long pageLoadTime = finish - start;  

        // Print the result  
        System.out.println("Page load time for " + url + " is " + pageLoadTime + " milliseconds");  

        // Close the browser  
 //       driver.quit();  
    
 

	}

}
