package Pages;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class ExtentReports_demo {
	
	public void extentReports() throws IOException {
		//ExtentHtmlReporter htmlReporter;
		//ExtentReports extent;		//helps to generate the logs in the test report.
	    //ExtentTest logger;
    	//C:\Users\Admin\technogeeks\First_maven_project\Extent_reports
	    
	    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\Admin\\technogeeks\\First_maven_project\\Extent_reports\\automation.html");
	 
        //initialize ExtentReports and attach the HtmlReporter
	    ExtentReports extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
	        
	    ExtentTest logger = extent.createTest("TC_01_Validlogin");
	        logger.log(Status.INFO, "Login to openMRS");
	        
	        logger.log(Status.PASS, "Title Verified");
	        logger.addScreenCaptureFromPath("C:\\Users\\Admin\\technogeeks\\First_maven_project\\Screenshots\\image.png");
	        extent.flush();
	}

}


