package zPractice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import basePage.BaseClass;

public class ExtentRpo implements ITestListener{

		
		public ExtentSparkReporter sparkReporter;
		public ExtentReports extent;
		public ExtentTest test;
		
		public String repName;

		public void onStart (ITestContext context) 
		{
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time
		     
		    repName = "Test-Report-" + timeStamp + ".html";
			sparkReporter =new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/"+repName);
		    
			sparkReporter.config().setDocumentTitle("Automation Report");
		    sparkReporter.config().setReportName("Functional Testing");
		    sparkReporter.config().setTheme(Theme.DARK);
		    
		    extent=new ExtentReports();
		    extent.attachReporter(sparkReporter);
		    
		    extent.setSystemInfo("Computer Name", "UAT");
		    extent.setSystemInfo("Enviornment", "QA");
		    extent.setSystemInfo("User Name", System.getProperty("user.name"));
		    extent.setSystemInfo("OS", "Win11");
		    extent.setSystemInfo("Browser Name", "Chrome");
		  
		}
		
		public void onTestSuccess(ITestResult result)
		{
			test= extent.createTest(result.getName());
			test.log(Status.PASS, "Test case PASSED is:" +result.getName());
			
			
		}
		
		public void onTestFailure(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.log(Status.FAIL, "Test case FAILED is:" +result.getName());
			test.log(Status.FAIL, "Test case FAILED cause is:" +result.getThrowable());
			
//Capture screenshot in Extent reports
			String imgPath = new BaseClass().captureScreen(result.getName()); 
			test.addScreenCaptureFromPath(imgPath);
			
		}
		
		public void onTestSkipped(ITestResult result)
		{
			test=extent.createTest(result.getName());
			test.log(Status.SKIP, "Test case Skipped:" +result.getName());
			test.log(Status.SKIP, "Test case Skipped cause is:" +result.getThrowable());
			
		}
		
		public void onFinish(ITestContext context) {
			
			extent.flush();
			
//to open report automatically after execution on test
			String pathOfExtentReport = System.getProperty("user.dir")+"\\reports\\"+repName;
			File extentReport = new File(pathOfExtentReport);
			
			try {
				Desktop.getDesktop().browse(extentReport.toURI());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
// To share generated reports to the specific gmail automatically after execution of test 
		
/*		try { URL url = new
		URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
		// Create the email message ImageHtmlEmail email = new ImageHtmlEmail(); 
		email.setDataSourceResolver (new DataSourceUrlResolver (url)); 
		email.setHostName("smtp.googlemail.com"); email.setSmtpPort(465);
		email.setAuthenticator(new
		DefaultAuthenticator("pavanoltraining@gmail.com","password"));
		email.setSSLOnConnect(true);
		email.setFrom("pavanoltraining@gmail.com");
		//Sender email.setSubject("Test Results"); email.setMsg("Please find Attached Report....");
		email.addTo("pavankumar.busyqa@gmail.com"); //Receiver email.attach(url, 
		"extent report", "please check report..."); email.send(); // send the email } 
	   catch (Exception e) { e.printStackTrace(); }
		}
*/
			
		
	}
