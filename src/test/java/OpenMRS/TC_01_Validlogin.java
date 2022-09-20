package OpenMRS;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.math3.stat.inference.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.ExtentReports_demo;
import Pages.LoginPage;
import Pages.functionality_openmrs;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class TC_01_Validlogin extends BaseClass {

	@Test(description="Test case_01_valid username and password validation")
	public void login() throws IOException {
		logger = extent.createTest("Validlogin in OpnMRS");
		LoginPage lp= new LoginPage(driver);
		lp.loginOpenMRS(obj.getProperty("username"), obj.getProperty("password"));
		
		//logger.log(Status.INFO, "Login to openMRS successfully");
		logger.info("app openMRS initialization");
						
		functionality_openmrs loc = new functionality_openmrs(driver);
		loc.findPatientRecord();
		Implicit_wait(10);		
		
		logger.pass("Login successful.....");
		
		driver.findElement(By.xpath("//input[@id='patient-search']")).sendKeys("100HM1");
		Implicit_wait(10);

		String name = driver.findElement(By.xpath("(//table[@id='patient-search-results-table']//tbody//td)[2]")).getText();
		Implicit_wait(10);
		
		
		
		//Assert.assertEquals(name,"Priya Rahul Malhotra", "Name is not correct");
		
		if(name.equals("Priya Rahul Malhotra")) {
			System.out.println("Patient name is correct: " + name);
		}else
			System.out.println("Name of patient is: " +name);
		Implicit_wait(10);
					
		logger.log(Status.FAIL, "Not able to login");
		
		loc.logOut();
	}
}
